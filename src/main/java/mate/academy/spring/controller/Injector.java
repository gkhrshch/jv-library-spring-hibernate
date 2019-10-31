package mate.academy.spring.controller;

import javax.annotation.PostConstruct;
import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Role;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.AuthorService;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RoleService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Injector {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @PostConstruct
    public void injectData() {
        Role adminRole = new Role();
        adminRole.setRoleName("ROLE_ADMIN");
        Role userRole = new Role();
        userRole.setRoleName("ROLE_USER");
        roleService.add(adminRole);
        roleService.add(userRole);

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(encoder.encode("admin"));
        admin.setEmail("admin@admin.com");
        userService.addAdmin(admin);

        Author author1 = new Author("name1", "surname1");
        Author author2 = new Author("name2", "surname2");
        Author author3 = new Author("name3", "surname3");
        Book book1 = new Book("book111", 1973, 1.11);
        Book book2 = new Book("book123", 1974, 1.12);
        Book book3 = new Book("book321", 1975, 1.13);
        book1.getAuthors().add(author1);
        book2.getAuthors().add(author2);
        book3.getAuthors().add(author2);
        book3.getAuthors().add(author3);
        bookService.add(book1);
        bookService.add(book2);
        bookService.add(book3);
    }
}
