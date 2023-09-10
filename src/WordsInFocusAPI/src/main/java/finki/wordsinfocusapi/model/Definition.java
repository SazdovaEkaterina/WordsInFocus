package finki.wordsinfocusapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class Definition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2550)
    private String definition_name;

    @Column(length = 2550)
    private String definition_example;

    @ManyToOne
    private Word word;
}
