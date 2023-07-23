package finki.wordsinfocusapi.service.impl;

import finki.wordsinfocusapi.model.Letter;
import finki.wordsinfocusapi.repository.LetterRepository;
import finki.wordsinfocusapi.service.LetterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetterServiceImpl implements LetterService {

    private final LetterRepository letterRepository;

    public LetterServiceImpl(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    @Override
    public Letter findById(Long id) {
        return this.letterRepository.findById(id).get();
    }

    @Override
    public List<Letter> findAll() {
        return this.letterRepository.findAll();
    }
}
