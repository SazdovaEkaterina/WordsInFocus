package finki.wordsinfocusapi.service.impl;

import finki.wordsinfocusapi.model.Definition;
import finki.wordsinfocusapi.model.Word;
import finki.wordsinfocusapi.model.dto.DefinitionDto;
import finki.wordsinfocusapi.model.dto.WordDto;
import finki.wordsinfocusapi.repository.DefinitionRepository;
import finki.wordsinfocusapi.repository.WordRepository;
import finki.wordsinfocusapi.service.DefinitionService;
import finki.wordsinfocusapi.service.WordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DefinitionServiceImpl implements DefinitionService {

    private final DefinitionRepository definitionRepository;
    private final WordRepository wordRepository;
    private final WordService wordService;

    public DefinitionServiceImpl(DefinitionRepository definitionRepository, WordRepository wordRepository, WordService wordService) {
        this.definitionRepository = definitionRepository;
        this.wordRepository = wordRepository;
        this.wordService = wordService;
    }

    @Override
    public DefinitionDto findById(Long letterId, Long wordId, Long id){

        WordDto wordDto = this.wordService.findById(letterId, wordId);

        if(wordDto == null){
            return null;
        }

        List<DefinitionDto> definitionDtos = this.findAllByWord(letterId, wordId);

        Optional<DefinitionDto> definitionDtoOptional = definitionDtos.stream()
                .filter(d -> Objects.equals(d.getId(), id))
                .findFirst();

        if(!definitionDtoOptional.isPresent()){
            return null;
        }

        return definitionDtoOptional.get();
    }

    @Override
    public List<DefinitionDto> findAllByWord(Long letterId, Long wordId) {

        WordDto wordDto = this.wordService.findById(letterId, wordId);

        if(wordDto == null){
            return null;
        }

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
