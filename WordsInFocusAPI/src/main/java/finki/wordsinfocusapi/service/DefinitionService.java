package finki.wordsinfocusapi.service;

import finki.wordsinfocusapi.model.dto.DefinitionDto;

import java.util.List;

public interface DefinitionService {

    DefinitionDto findById(Long letterId, Long wordId, Long id);
    List<DefinitionDto> findAllByWord(Long letterId, Long wordId);
}
