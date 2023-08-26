package finki.wordsinfocusapi.controller;

import finki.wordsinfocusapi.model.dto.DefinitionDto;
import finki.wordsinfocusapi.service.DefinitionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/letters/{letterId}/words/{wordId}/definitions")
public class DefinitionRestController {

    private final DefinitionService definitionService;

    public DefinitionRestController(DefinitionService definitionService) {
        this.definitionService = definitionService;
    }

    @GetMapping
    public List<DefinitionDto> getAllByWordId(@PathVariable Long wordId){
        return this.definitionService.findAllByWord(wordId);
    }

    @GetMapping("/{id}")
    public DefinitionDto getById(@PathVariable Long id){
        return this.definitionService.findById(id);
    }
}
