package finki.wordsinfocusapi.service;

import finki.wordsinfocusapi.model.dto.DefinitionDto;

import java.util.List;
import java.util.Optional;

public interface DefinitionService {

    DefinitionDto findById(Long id);
    List<DefinitionDto> findAllByWord(Long wordId);
}
