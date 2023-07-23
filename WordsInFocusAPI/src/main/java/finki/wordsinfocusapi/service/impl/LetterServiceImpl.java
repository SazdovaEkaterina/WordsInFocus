package finki.wordsinfocusapi.service.impl;

import finki.wordsinfocusapi.model.Letter;
import finki.wordsinfocusapi.repository.LetterRepository;
import finki.wordsinfocusapi.service.LetterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LetterServiceImpl implements LetterService {

    private final LetterRepository letterRepository;

    public LetterServiceImpl(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    @Override
    public Optional<Letter> findById(Long id) {
        return this.letterRepository.findById(id);
    }

    @Override
    public List<Letter> findAll() {
        return this.letterRepository.findAll();
    }
}
