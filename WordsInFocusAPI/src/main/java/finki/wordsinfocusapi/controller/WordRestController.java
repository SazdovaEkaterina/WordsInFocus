package finki.wordsinfocusapi.controller;

import finki.wordsinfocusapi.model.Word;
import finki.wordsinfocusapi.service.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/words")
public class WordRestController {

    private final WordService wordService;

    public WordRestController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public List<Word> getAll(){
        return this.wordService.findAll();
    }

//    @GetMapping
//    public List<Word> getAllByLetterId(@RequestParam Long letterId){
//        return this.wordService.findAllByLetter(letterId);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Word> getById(@PathVariable Long id){
        return this.wordService.findById(id)
                .map(word -> ResponseEntity.ok().body(word))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
