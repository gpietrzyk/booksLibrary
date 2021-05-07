package pl.github.gpietrzyk.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

///////////////
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
///////////////

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    @NotBlank(message = "Author's first name must not be empty!")
    private String firstName;
    private String middleName;
    private String lastName;

    //Lombok
    @Builder.Default
    //
    @ManyToMany
    @JoinTable(name = "book_authors", joinColumns = {@JoinColumn(name = "author_id")}, inverseJoinColumns = {
            @JoinColumn(name = "book_id")})
    private List<Book> books = new ArrayList<>();



}
