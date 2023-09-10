package finki.wordsinfocusapi.controller;

import finki.wordsinfocusapi.model.dto.LetterDto;
import finki.wordsinfocusapi.model.dto.WordDto;
import finki.wordsinfocusapi.service.LetterService;
import finki.wordsinfocusapi.service.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080/")
@RequestMapping("/api/letters/{letterId}/words")
public class WordRestController {

    private final WordService wordService;
    private final LetterService letterService;

    public WordRestController(WordService wordService,
                              LetterService letterService) {
        this.wordService = wordService;
        this.letterService = letterService;
    }

    @GetMapping
    public ResponseEntity<List<WordDto>> getAllByLetterId(
            @PathVariable Long letterId){

        LetterDto letterDto = this.letterService.findById(letterId);

        if(letterDto == null){
            return ResponseEntity.notFound().build();
        }

        List<WordDto> wordDtos = this.wordService.findAllByLetter(letterId);

        return ResponseEntity.ok().body(wordDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WordDto> getById(
            @PathVariable Long letterId,
            @PathVariable Long id){

        LetterDto letterDto = this.letterService.findById(letterId);

        if(letterDto == null){
            return ResponseEntity.notFound().build();
        }

        WordDto wordDto = this.wordService.findById(letterId, id);

        if(wordDto == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(wordDto);
    }

    @GetMapping("byWord/{word}")
    public ResponseEntity<WordDto> getByWord(
            @PathVariable Long letterId,
            @PathVariable String word){

        LetterDto letterDto = this.letterService.findById(letterId);

        if(letterDto == null){
            return ResponseEntity.notFound().build();
        }

        WordDto wordDto = this.wordService.findByWord(letterId, word);

        if(wordDto == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(wordDto);
    }
}
