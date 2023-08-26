package finki.wordsinfocusapi.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class WordDto {

    private Long id;

    private String word;

    private String name;

    private String type;

    private Long letterId;

    public WordDto() {
    }

    public WordDto(Long id, String word, String name, String type, Long letterId) {
        this.id = id;
        this.word = word;
        this.name = name;
        this.type = type;
        this.letterId = letterId;
    }
}
