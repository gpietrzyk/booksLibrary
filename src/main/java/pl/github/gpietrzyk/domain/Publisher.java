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
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publisherId;
    @NotBlank(message = "Publisher name must be not empty")
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    List<Book> books = new ArrayList<>();


}
