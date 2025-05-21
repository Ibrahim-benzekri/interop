package fr.ensim.interop.introrest.controller;

import fr.ensim.interop.introrest.model.Joke;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
public class JokeController {
    ArrayList<Joke> jokeList = new ArrayList<>();
    public JokeController() {
        jokeList.add(new Joke(1L, "Plongée mystérieuse", "Pourquoi les plongeurs plongent-ils toujours en arrière et jamais en avant ?", 10));
        jokeList.add(new Joke(2L, "La chute du plongeur", "Parce que sinon ils tombent dans le bateau.", 4));
        jokeList.add(new Joke(3L, "Le comble de l'électricien", "Quel est le comble pour un électricien ?", 3));
        jokeList.add(new Joke(4L, "Pas au courant", "De ne pas être au courant.", 4));


    }
    @GetMapping("/joke")
    public ResponseEntity<Joke> getRandomJoke(
            @RequestParam(value = "level", required = false) Integer level) {

        ArrayList<Joke> filtered;

        if (level == null) {
            // Pas de filtre, retourne toutes les blagues
            filtered = jokeList;
        } else if (level == 1) {
            // niveau 1 : note entre 0 et 5 inclus
            filtered = (ArrayList<Joke>) jokeList.stream()
                    .filter(j -> j.getNote() >= 0 && j.getNote() <= 5)
                    .collect(Collectors.toList());
        } else if (level == 2) {
            // niveau 2 : note > 5
            filtered = (ArrayList<Joke>) jokeList.stream()
                    .filter(j -> j.getNote() > 5)
                    .collect(Collectors.toList());
        } else {
            // niveau invalide
            return ResponseEntity.badRequest().build();
        }

        if (filtered.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Random rnd = new Random();
        Joke randomJoke = filtered.get(rnd.nextInt(filtered.size()));
        return ResponseEntity.ok(randomJoke);
    }
}
