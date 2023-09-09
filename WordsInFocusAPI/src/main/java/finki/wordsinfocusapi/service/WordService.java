package finki.wordsinfocusapi.service;

import finki.wordsinfocusapi.model.dto.WordDto;

import java.util.List;

public interface WordService {

    WordDto findById(Long letterId, Long id);
    WordDto findByWord(Long letterId, String word);
    List<WordDto> findAllByLetter(Long letterId);

}
