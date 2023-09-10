package finki.wordsinfocusapi.model.dto;

import lombok.Data;

@Data
public class LetterDto {

    private Long id;

    private String name;

    public LetterDto() {
    }

    public LetterDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
