package finki.wordsinfocusapi.service;

import finki.wordsinfocusapi.model.Word;

import java.util.List;
import java.util.Optional;

public interface WordService {

    Optional<Word> findById(Long id);
    List<Word> findAll();
    List<Word> findAllByLetter(Long letterId);

}
