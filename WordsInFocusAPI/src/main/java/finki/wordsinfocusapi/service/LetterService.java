package finki.wordsinfocusapi.service;

import finki.wordsinfocusapi.model.Letter;

import java.util.List;
import java.util.Optional;

public interface LetterService {

    Optional<Letter> findById(Long id);
    List<Letter> findAll();
    void save(Letter letter);

}
