package finki.wordsinfocusapi.model.dto;

import finki.wordsinfocusapi.model.Word;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class LetterDto {

    private String name;

    private List<WordDto> words;

    public LetterDto() {
    }

    public LetterDto(String name, List<WordDto> words) {
        this.name = name;
        this.words = words;
    }
}
