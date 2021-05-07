package pl.github.gpietrzyk.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.github.gpietrzyk.domain.Author;
import pl.github.gpietrzyk.service.AuthorService;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("app/authors")
public class AuthorController {
    private final AuthorService authorService;


    @GetMapping()
    public ResponseEntity<List<Author>> findAll() {
        List<Author> authors = authorService.findAllAuthors();
        return ResponseEntity.status(HttpStatus.OK).body(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable("id") Integer id) {
        Author author = authorService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(author);
    }

    @PostMapping()
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        Author newAuthor = authorService.createAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAuthor);
    }

    @PutMapping()
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
        Author updateAuthor = authorService.createAuthor(author);
        return ResponseEntity.status(HttpStatus.OK).body(updateAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthorById(@PathVariable("id") Integer id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
