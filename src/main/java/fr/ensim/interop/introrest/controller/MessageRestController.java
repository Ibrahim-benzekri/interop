package fr.ensim.interop.introrest.controller;

import fr.ensim.interop.introrest.model.telegram.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MessageRestController {

	@Value("${telegram.api.url}")
	private String telegramApiUrl;

	@Value("${telegram.bot.id}")
	private String telegramToken;

	@PostMapping("/message")
	public ResponseEntity<String> sendMessage(@RequestBody Message request) {


		String url = telegramApiUrl + telegramToken + "/sendMessage";

		RestTemplate restTemplate = new RestTemplate();


		System.out.println("message : " + request.getChatId());
		Map<String, Object> body = new HashMap<>();
		body.put("chat_id", request.getChatId());
		body.put("text", request.getText());

		// Entêtes de la requête (Content-Type: application/json)
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

		try {
			ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
			return ResponseEntity.ok(response.getBody());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erreur lors de l'envoi à Telegram : " + e.getMessage());
		}
	}
}
