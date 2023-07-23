package finki.wordsinfocusapi.service.impl;

import finki.wordsinfocusapi.model.Word;
import finki.wordsinfocusapi.repository.WordRepository;
import finki.wordsinfocusapi.service.WordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;

    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public Word findById(Long id) {
        return this.wordRepository.findById(id).get();
    }

    @Override
    public List<Word> findAll() {
        return this.wordRepository.findAll();
    }
}
