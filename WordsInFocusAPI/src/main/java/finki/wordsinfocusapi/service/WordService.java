package finki.wordsinfocusapi.service;

import finki.wordsinfocusapi.model.Word;

import java.util.List;

public interface WordService {

    Word findById(Long id);
    List<Word> findAll();

}
