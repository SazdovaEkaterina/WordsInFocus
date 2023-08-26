package finki.wordsinfocusapi.model.dto;

import lombok.Data;

@Data
public class DefinitionDto {

    private String definition_name;

    private String definition_example;

    private Long wordId;

    public DefinitionDto() {
    }

    public DefinitionDto(String definition_name, String definition_example, Long wordId) {
        this.definition_name = definition_name;
        this.definition_example = definition_example;
        this.wordId = wordId;
    }

}
