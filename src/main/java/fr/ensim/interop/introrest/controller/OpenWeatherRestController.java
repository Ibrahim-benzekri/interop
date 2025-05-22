package fr.ensim.interop.introrest.controller;

import fr.ensim.interop.introrest.model.City;
import fr.ensim.interop.introrest.model.Forecast;
import fr.ensim.interop.introrest.model.Meteo;
import fr.ensim.interop.introrest.model.OpenWeather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OpenWeatherRestController {
	@Value("${open.weather.api.token}")
	private String weather_token;
	@Value("${open.weather.api.url}")
	private String weather_base_url;


	@GetMapping("/meteo")
	public ResponseEntity<String> meteoByVille(
			@RequestParam("ville") String nomVille) {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<City[]> responseEntity = restTemplate.getForEntity(weather_base_url+"geo/1.0/direct?q={ville}&limit=3"
																				  + "&appid=" + weather_token,
																		  City[].class, nomVille);
		City[] cities = responseEntity.getBody();
		City city = cities[0];

		OpenWeather openWeather = restTemplate.getForObject(weather_base_url+"data/2.5/weather?lat={lat}"
																	+ "&lon={longitude}&units=metric&lang=fr&appid=" + weather_token+"&units=metric&lang=fr",
															OpenWeather.class, city.getLat(), city.getLon());
		
		Meteo meteo = new Meteo();
		meteo.setMeteo(openWeather.getWeather().get(0).getMain());
		meteo.setDetails(openWeather.getWeather().get(0).getDescription());
		meteo.setTemperature(openWeather.getMain().getTemp()); 

		return ResponseEntity.ok().body("Bonjour, aujourd'hui la temperature a "+nomVille+" est de "+meteo.getTemperature()+" degree, la meteo est  "+meteo.getMeteo()+", le temps est "+meteo.getDetails());
	}

	@GetMapping("/meteo2")
	public ResponseEntity<?> meteoByVille5d(
			@RequestParam("ville") String nomVille) {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<City[]> responseEntity = restTemplate.getForEntity(weather_base_url+"geo/1.0/direct?q={ville}&limit=3"
																				  + "&appid=" + weather_token,
																		  City[].class, nomVille);
		City[] cities = responseEntity.getBody();
		City city = cities[0];

		Forecast openWeather = restTemplate.getForObject(weather_base_url+"data/2.5/forecast?lat={lat}"
																	+ "&lon={longitude}&units=metric&lang=fr&appid=" + weather_token,
															Forecast.class, city.getLat(), city.getLon());
		List<Meteo> meteos = new ArrayList<>();
		for (OpenWeather x: openWeather.getList()
			 ) {
			Meteo meteo = new Meteo();
			meteo.setMeteo(x.getWeather().get(0).getMain());
			meteo.setDetails(x.getWeather().get(0).getDescription());
			meteo.setTemperature(x.getMain().getTemp());

			meteos.add(meteo);
		}

		List<Meteo> twodays = meteos.subList(0, Math.min(16, meteos.size()));


		return ResponseEntity.ok().body(formatTwodaysForecast(openWeather.getList()));
	}

	public String formatTwodaysForecast(List<OpenWeather> entries) {
		StringBuilder sb = new StringBuilder();
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy");
		DateTimeFormatter hourFormatter = DateTimeFormatter.ofPattern("HH:mm");

		String currentDay = "";
		int dayCount = 0;

		for (OpenWeather weatherEntry : entries) {
			LocalDateTime dateTime = LocalDateTime.parse(weatherEntry.getDt_txt(), inputFormatter);
			String day = dayFormatter.format(dateTime);
			String hour = hourFormatter.format(dateTime);

			if (!day.equals(currentDay)) {
				currentDay = day;
				dayCount++;
				sb.append("\n**Jour ").append(dayCount).append(" : ").append(currentDay).append("**\n");
			}

			String main = weatherEntry.getWeather().get(0).getMain();
			String description = weatherEntry.getWeather().get(0).getDescription();
			double temp = Double.parseDouble(weatherEntry.getMain().getTemp());

			sb.append("- ").append(hour).append(" → ")
					.append(main).append(" (").append(description).append("), ")
					.append(String.format("%.1f", temp)).append("°C\n");
		}

		return sb.toString();
	}


}
