package finki.wordsinfocusapi.controller;

import finki.wordsinfocusapi.model.dto.WordDto;
import finki.wordsinfocusapi.service.WordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/letters/{letterId}/words")
public class WordRestController {

    private final WordService wordService;

    public WordRestController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public List<WordDto> getAllByLetterId(@PathVariable Long letterId){
        return this.wordService.findAllByLetter(letterId);
    }

    @GetMapping("/{id}")
    public WordDto getById(@PathVariable Long letterId, @PathVariable Long id){
        return this.wordService.findById(id);
    }
}
