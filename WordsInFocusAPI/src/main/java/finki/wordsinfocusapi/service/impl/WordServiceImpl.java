package finki.wordsinfocusapi.service.impl;

import finki.wordsinfocusapi.model.Letter;
import finki.wordsinfocusapi.model.Word;
import finki.wordsinfocusapi.repository.LetterRepository;
import finki.wordsinfocusapi.repository.WordRepository;
import finki.wordsinfocusapi.service.WordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;
    private final LetterRepository letterRepository;

    public WordServiceImpl(WordRepository wordRepository, LetterRepository letterRepository) {
        this.wordRepository = wordRepository;
        this.letterRepository = letterRepository;
    }

    @Override
    public Optional<Word> findById(Long id) {
        return this.wordRepository.findById(id);
    }

    @Override
    public List<Word> findAll() {
        return this.wordRepository.findAll();
    }

    @Override
    public List<Word> findAllByLetter(Long letterId) {
        Letter letter = this.letterRepository.findById(letterId).get();
        return this.wordRepository.findAllByLetter(letter);
    }
}
