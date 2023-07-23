package finki.wordsinfocusapi.repository;

import finki.wordsinfocusapi.model.Definition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefinitionRepository extends JpaRepository<Definition, Long> {
}
