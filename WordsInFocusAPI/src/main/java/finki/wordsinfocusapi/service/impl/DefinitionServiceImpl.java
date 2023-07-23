package finki.wordsinfocusapi.service.impl;

import finki.wordsinfocusapi.model.Definition;
import finki.wordsinfocusapi.repository.DefinitionRepository;
import finki.wordsinfocusapi.service.DefinitionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefinitionServiceImpl implements DefinitionService {

    private final DefinitionRepository definitionRepository;

    public DefinitionServiceImpl(DefinitionRepository definitionRepository) {
        this.definitionRepository = definitionRepository;
    }

    @Override
    public Definition findById(Long id) {
        return this.definitionRepository.findById(id).get();
    }

    @Override
    public List<Definition> findAll() {
        return this.definitionRepository.findAll();
    }
}
