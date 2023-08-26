package finki.wordsinfocusapi.service.impl;

import finki.wordsinfocusapi.model.Definition;
import finki.wordsinfocusapi.model.Word;
import finki.wordsinfocusapi.model.dto.DefinitionDto;
import finki.wordsinfocusapi.repository.DefinitionRepository;
import finki.wordsinfocusapi.repository.WordRepository;
import finki.wordsinfocusapi.service.DefinitionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DefinitionServiceImpl implements DefinitionService {

    private final DefinitionRepository definitionRepository;
    private final WordRepository wordRepository;

    public DefinitionServiceImpl(DefinitionRepository definitionRepository, WordRepository wordRepository) {
        this.definitionRepository = definitionRepository;
        this.wordRepository = wordRepository;
    }

    @Override
    public DefinitionDto findById(Long id){

        Optional<Definition> definitionOptional = this.definitionRepository.findById(id);

        if(!definitionOptional.isPresent()){
            return null;
        }

        Definition definition = definitionOptional.get();

        return new DefinitionDto(definition.getId(),
                definition.getDefinition_name(),
                definition.getDefinition_example(),
                definition.getWord().getId());
    }

    @Override
    public List<DefinitionDto> findAllByWord(Long wordId) {

        Word word = this.wordRepository.findById(wordId).get();
        List<Definition> definitions = this.definitionRepository.findAllByWord(word);
        List<DefinitionDto> definitionDtos = new ArrayList<>();

        for (var definition:definitions) {
            definitionDtos.add(new DefinitionDto(definition.getId(),
                    definition.getDefinition_name(),
                    definition.getDefinition_example(),
                    definition.getWord().getId()));
        }

        return definitionDtos;
    }
}
