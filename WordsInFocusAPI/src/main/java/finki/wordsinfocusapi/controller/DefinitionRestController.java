package finki.wordsinfocusapi.controller;

import finki.wordsinfocusapi.model.Definition;
import finki.wordsinfocusapi.service.DefinitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/definitions")
public class DefinitionRestController {

    private final DefinitionService definitionService;

    public DefinitionRestController(DefinitionService definitionService) {
        this.definitionService = definitionService;
    }

    @GetMapping
    public List<Definition> getAll(){
        return this.definitionService.findAll();
    }

//    @GetMapping("/{wordId}")
//    public List<Definition> getAllByWordId(@PathVariable Long wordId){
//        return this.definitionService.findAllByWord(wordId);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Definition> getById(@PathVariable Long id){
        return this.definitionService.findById(id)
                .map(definition -> ResponseEntity.ok().body(definition))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
