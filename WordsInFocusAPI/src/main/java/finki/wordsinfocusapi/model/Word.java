package finki.wordsinfocusapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String word;

    private String name;

    private String type;

    @OneToMany(mappedBy = "word")
    private List<Definition> definitions;

    @ManyToOne
    private Letter letter;
}
