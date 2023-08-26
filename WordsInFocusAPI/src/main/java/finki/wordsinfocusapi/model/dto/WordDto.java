package finki.wordsinfocusapi.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class WordDto {

    private String word;

    private String name;

    private String type;

    private List<DefinitionDto> definitions;

    private Long letterId;

    public WordDto() {
    }

    public WordDto(String word, String name, String type, List<DefinitionDto> definitions, Long letterId) {
        this.word = word;
        this.name = name;
        this.type = type;
        this.definitions = definitions;
        this.letterId = letterId;
    }
}
