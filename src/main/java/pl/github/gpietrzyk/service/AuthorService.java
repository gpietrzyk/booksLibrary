package pl.github.gpietrzyk.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.github.gpietrzyk.domain.Author;
import pl.github.gpietrzyk.exception.AuthorNotFoundException;
import pl.github.gpietrzyk.repository.AuthorRepository;

import javax.transaction.Transactional;
import java.util.List;


@RequiredArgsConstructor

@Transactional
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    public List<Author> findAllAuthors(){
        List<Author> authors = authorRepository.findAll();
        return authors;
    }

    public Author findById(Integer id){
        Author author = authorRepository.findById(id)
                .orElseThrow(()-> new AuthorNotFoundException("Author by "+ id + " was not found"));
        return author;
    }

    public Author updateAuthor(Author author){
        return authorRepository.save(author);
    }

    public void deleteAuthor(Integer id){
        authorRepository.deleteAuthorByAuthorId(id);
    }
}
