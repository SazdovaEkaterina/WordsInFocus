package finki.wordsinfocusapi.service;

import finki.wordsinfocusapi.model.Letter;

import java.util.List;

public interface LetterService {

    Letter findById(Long id);
    List<Letter> findAll();

}
