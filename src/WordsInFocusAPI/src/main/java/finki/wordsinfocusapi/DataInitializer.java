package finki.wordsinfocusapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import finki.wordsinfocusapi.model.Letter;
import finki.wordsinfocusapi.service.LetterService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
        List<String> letters = new ArrayList<>(Arrays.asList(
                "а", "б", "в", "г", "д", "ѓ", "е",
                "ж", "з", "ѕ", "и", "ј", "к", "л",
                "љ", "м", "н", "њ", "о", "п", "р",
                "с", "т", "ќ", "у", "ф", "х", "ц",
                "ч", "џ", "ш"));

        for (String letterValue:letters) {
            Letter letter = objectMapper
                    .readValue(new File("src/main/resources/wordsInJson/"+letterValue+".json"), Letter.class);

            letterService.save(letter);
        }

    }

}
