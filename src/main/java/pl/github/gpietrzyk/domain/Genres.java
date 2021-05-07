package pl.github.gpietrzyk.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

///////////////
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
///////////////



@Entity
@Table(name = "genres")
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreId;
    @NotBlank(message = "Genre's description must be not null!")
    private String genre;
    @ManyToMany()
    @JoinTable(name = "book_genres",joinColumns = {@JoinColumn(name = "genre_id")}, inverseJoinColumns = {
            @JoinColumn(name = "book_id")})
    private Set<Book> books = new HashSet<>();
}
