package finki.wordsinfocusapi.model.dto;

import finki.wordsinfocusapi.model.Word;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

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
