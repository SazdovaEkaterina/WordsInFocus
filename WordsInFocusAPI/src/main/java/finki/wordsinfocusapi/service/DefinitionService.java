package finki.wordsinfocusapi.service;

import finki.wordsinfocusapi.model.Definition;

import java.util.List;
import java.util.Optional;

public interface DefinitionService {

    Optional<Definition> findById(Long id);
    List<Definition> findAll();
    List<Definition> findAllByWord(Long wordId);
}
