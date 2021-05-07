package pl.github.gpietrzyk.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private int bookId;

    @Column(name = "title", nullable = false)
    @NotBlank(message = "Book title must be not empty")
    private String title;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "book_authors", joinColumns = {@JoinColumn(name = "book_id")}, inverseJoinColumns = {
            @JoinColumn(name = "author_id")})
    List<Author> authors = new ArrayList<>();

    @Column(name = "book_id")
    private int totalPages;

    @Column(name = "book_id")
    private Date published_date;


    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToMany()
    @JoinTable(name = "book_genres", joinColumns = { @JoinColumn(name = "book_id")}, inverseJoinColumns = {
            @JoinColumn(name = "genre_id")})
    private Set<Genres> genres = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;
}
