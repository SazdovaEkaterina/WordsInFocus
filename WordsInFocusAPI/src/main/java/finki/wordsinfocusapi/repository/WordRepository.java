package finki.wordsinfocusapi.repository;

import finki.wordsinfocusapi.model.Letter;
import finki.wordsinfocusapi.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    List<Word> findAllByLetter(Letter letter);
}
