package finki.wordsinfocusapi.service.impl;

import finki.wordsinfocusapi.model.Definition;
import finki.wordsinfocusapi.model.Letter;
import finki.wordsinfocusapi.model.Word;
import finki.wordsinfocusapi.model.dto.DefinitionDto;
import finki.wordsinfocusapi.model.dto.WordDto;
import finki.wordsinfocusapi.repository.LetterRepository;
import finki.wordsinfocusapi.repository.WordRepository;
import finki.wordsinfocusapi.service.WordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;
    private final LetterRepository letterRepository;

    public WordServiceImpl(WordRepository wordRepository, LetterRepository letterRepository) {
        this.wordRepository = wordRepository;
        this.letterRepository = letterRepository;
    }

    @Override
    public WordDto findById(Long id) {
        Optional<Word> wordOptional = this.wordRepository.findById(id);

        if(!wordOptional.isPresent()){
            return null;
        }

        Word word = wordOptional.get();

        return new WordDto(word.getId(),
                word.getWord(),
                word.getName(),
                word.getType(),
                word.getLetter().getId());
    }

    @Override
    public List<WordDto> findAllByLetter(Long letterId) {

        Letter letter = this.letterRepository.findById(letterId).get();
        List<Word> words = this.wordRepository.findAllByLetter(letter);
        List<WordDto> wordDtos = new ArrayList<>();

        for (var word: words) {
            wordDtos.add(new WordDto(word.getId(),
                    word.getWord(),
                    word.getName(),
                    word.getType(),
                    word.getLetter().getId()));
        }

        return wordDtos;
    }
}
