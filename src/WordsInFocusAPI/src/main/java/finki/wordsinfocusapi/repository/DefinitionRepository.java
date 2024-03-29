package finki.wordsinfocusapi.repository;

import finki.wordsinfocusapi.model.Definition;
import finki.wordsinfocusapi.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DefinitionRepository extends JpaRepository<Definition, Long> {
    List<Definition> findAllByWord(Word word);
}
