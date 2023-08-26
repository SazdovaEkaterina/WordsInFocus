package finki.wordsinfocusapi.service;

import finki.wordsinfocusapi.model.Letter;
import finki.wordsinfocusapi.model.dto.LetterDto;

import java.util.List;

public interface LetterService {

    LetterDto findById(Long id);
    List<LetterDto> findAll();
    void save(Letter letter);

}
