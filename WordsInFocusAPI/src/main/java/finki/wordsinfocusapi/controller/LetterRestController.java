package finki.wordsinfocusapi.controller;

import finki.wordsinfocusapi.model.dto.LetterDto;
import finki.wordsinfocusapi.service.LetterService;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> e0633b34171db87b7dec65aacbb6409163fb94c5

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
    public ResponseEntity<LetterDto> getById(
            @PathVariable Long id){

        LetterDto letterDto = this.letterService.findById(id);

        if(letterDto == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(letterDto);
    }

}
