package fr.ensim.interop.introrest.model;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Joke {
    private Long id;
    private String title;
    private String text;
    private int note;
}
