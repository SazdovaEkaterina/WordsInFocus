package finki.wordsinfocusapi.controller;

import finki.wordsinfocusapi.model.dto.DefinitionDto;
import finki.wordsinfocusapi.model.dto.LetterDto;
import finki.wordsinfocusapi.model.dto.WordDto;
import finki.wordsinfocusapi.service.DefinitionService;
import finki.wordsinfocusapi.service.LetterService;
import finki.wordsinfocusapi.service.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/letters/{letterId}/words/{wordId}/definitions")
public class DefinitionRestController {

    private final DefinitionService definitionService;
    private final WordService wordService;
    private final LetterService letterService;

    public DefinitionRestController(DefinitionService definitionService, WordService wordService, LetterService letterService) {
        this.definitionService = definitionService;
        this.wordService = wordService;
        this.letterService = letterService;
    }

    @GetMapping
    public ResponseEntity<List<DefinitionDto>> getAllByWordId(
            @PathVariable Long letterId,
            @PathVariable Long wordId){

        LetterDto letterDto = this.letterService.findById(letterId);

        if(letterDto == null){
            return ResponseEntity.notFound().build();
        }

        WordDto wordDto = this.wordService.findById(letterId, wordId);

        if(wordDto == null){
            return ResponseEntity.notFound().build();
        }

        List<DefinitionDto> definitionDtos = this.definitionService.findAllByWord(letterId, wordId);

        return ResponseEntity.ok().body(definitionDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefinitionDto> getById(
            @PathVariable Long letterId,
            @PathVariable Long wordId,
            @PathVariable Long id){

        LetterDto letterDto = this.letterService.findById(letterId);

        if(letterDto == null){
            return ResponseEntity.notFound().build();
        }

        WordDto wordDto = this.wordService.findById(letterId, wordId);

        if(wordDto == null){
            return ResponseEntity.notFound().build();
        }

        DefinitionDto definitionDto = this.definitionService.findById(letterId, wordId, id);

        if(definitionDto == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(definitionDto);
    }
}
