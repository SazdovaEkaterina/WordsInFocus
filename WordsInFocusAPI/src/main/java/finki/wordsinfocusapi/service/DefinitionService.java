package finki.wordsinfocusapi.service;

import finki.wordsinfocusapi.model.Definition;

import java.util.List;

public interface DefinitionService {

    Definition findById(Long id);
    List<Definition> findAll();

}
