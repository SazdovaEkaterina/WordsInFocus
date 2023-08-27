package finki.wordsinfocusapi.controller;

import finki.wordsinfocusapi.model.dto.LetterDto;
import finki.wordsinfocusapi.service.LetterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080/")
@RequestMapping("/api/letters")
public class    LetterRestController {

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
