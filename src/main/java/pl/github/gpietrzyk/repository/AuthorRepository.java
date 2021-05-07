package pl.github.gpietrzyk.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.github.gpietrzyk.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    public void deleteAuthorByAuthorId(Integer id);
}
