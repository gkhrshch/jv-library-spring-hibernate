package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.entity.Author;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    void add(Author author);

    List<Author> listAuthors();

    List<Author> findByName(String name);

    List<Author> findByNameAndSurname(String name, String surname);
}
