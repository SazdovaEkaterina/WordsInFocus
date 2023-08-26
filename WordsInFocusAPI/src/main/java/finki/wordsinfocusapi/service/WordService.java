package finki.wordsinfocusapi.service;

import finki.wordsinfocusapi.model.Word;
import finki.wordsinfocusapi.model.dto.WordDto;

import java.util.List;
import java.util.Optional;

public interface WordService {

    WordDto findById(Long id);
    List<WordDto> findAllByLetter(Long letterId);

}
