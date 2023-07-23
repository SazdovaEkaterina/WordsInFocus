package finki.wordsinfocusapi.service.impl;

import finki.wordsinfocusapi.model.Definition;
import finki.wordsinfocusapi.model.Word;
import finki.wordsinfocusapi.repository.DefinitionRepository;
import finki.wordsinfocusapi.repository.WordRepository;
import finki.wordsinfocusapi.service.DefinitionService;
import org.springframework.stereotype.Service;

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
    public Optional<Definition> findById(Long id) {
        return this.definitionRepository.findById(id);
    }

    @Override
    public List<Definition> findAll() {
        return this.definitionRepository.findAll();
    }

    @Override
    public List<Definition> findAllByWord(Long wordId) {
        Word word = this.wordRepository.findById(wordId).get();
        return this.definitionRepository.findAllByWord(word);
    }
}
