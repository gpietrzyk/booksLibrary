package pl.github.gpietrzyk.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/books")
public class BookController {
    @GetMapping
    public String showBooks(){
        return "books";
    }
}
