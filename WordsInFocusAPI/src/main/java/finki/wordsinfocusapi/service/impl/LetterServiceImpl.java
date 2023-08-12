package finki.wordsinfocusapi.service.impl;

import finki.wordsinfocusapi.model.Definition;
import finki.wordsinfocusapi.model.Letter;
import finki.wordsinfocusapi.model.Word;
import finki.wordsinfocusapi.repository.DefinitionRepository;
import finki.wordsinfocusapi.repository.LetterRepository;
import finki.wordsinfocusapi.repository.WordRepository;
import finki.wordsinfocusapi.service.LetterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LetterServiceImpl implements LetterService {

    private final LetterRepository letterRepository;
    private final WordRepository wordRepository;
    private final DefinitionRepository definitionRepository;

    public LetterServiceImpl(LetterRepository letterRepository, WordRepository wordRepository, DefinitionRepository definitionRepository) {
        this.letterRepository = letterRepository;
        this.wordRepository = wordRepository;
        this.definitionRepository = definitionRepository;
    }

    @Override
    public Optional<Letter> findById(Long id) {
        return this.letterRepository.findById(id);
    }

    @Override
    public List<Letter> findAll() {
        return this.letterRepository.findAll();
    }

    @Override
    public void save(Letter letter) {
        letterRepository.save(letter);
        for (Word word: letter.getWords()) {
            word.setLetter(letter);
            wordRepository.save(word);
            for (Definition definition: word.getDefinitions()) {
                definition.setWord(word);
                definitionRepository.save(definition);
            }
        }
    }
}
