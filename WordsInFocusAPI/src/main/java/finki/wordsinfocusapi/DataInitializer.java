package finki.wordsinfocusapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import finki.wordsinfocusapi.model.Letter;
import finki.wordsinfocusapi.model.Word;
import finki.wordsinfocusapi.service.LetterService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.PostUpdate;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {

    private final LetterService letterService;

    public DataInitializer(LetterService letterService) {
        this.letterService = letterService;
    }

    @PostConstruct
    public void InitializeData() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        List<String> letters = new ArrayList<>();
        letters.add("а");
        letters.add("б");

        for (String letterValue:letters) {
            Letter letter = objectMapper
                    .readValue(new File("src/main/resources/wordsInJson/"+letterValue+".json"), Letter.class);
            System.out.println(letter);

            letterService.save(letter);
        }

    }

}
