package finki.wordsinfocusapi.controller;

import finki.wordsinfocusapi.model.dto.LetterDto;
import finki.wordsinfocusapi.service.LetterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/letters")
public class LetterRestController {

    private final LetterService letterService;

    public LetterRestController(LetterService letterService) {
        this.letterService = letterService;
    }

    @GetMapping
    public List<LetterDto> getAll(){
        return this.letterService.findAll();
    }

    @GetMapping("/{id}")
    public LetterDto getById(@PathVariable Long id){
        return this.letterService.findById(id);
    }

}
