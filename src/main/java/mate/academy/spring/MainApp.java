package mate.academy.spring;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import mate.academy.spring.config.AppConfig;
import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.AuthorService;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.LibraryService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        // Add Users
        userService.add(new User("Sunil", "Bora", "suni.bora@example.com"));
        userService.add(new User("David", "Miller", "david.miller@example.com"));
        userService.add(new User("Sameer", "Singh", "sameer.singh@example.com"));
        userService.add(new User("Paul", "Smith", "paul.smith@example.com"));

        // Get Users
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        //Add Books
        BookService bookService = context.getBean(BookService.class);
        bookService.add(new Book("book111", 1973, 1.11));
        bookService.add(new Book("book123", 1974, 1.12));
        bookService.add(new Book("book321", 1975, 1.13));
        List<Book> books = bookService.listBooks();
        for (Book book : books) {
            System.out.println("Id = " + book.getId());
            System.out.println("Title = " + book.getTitle());
            System.out.println("Publishing Year = " + book.getYear());
            System.out.println("Price = " + book.getPrice());
            System.out.println();
        }

        //Books by title
        List<Book> booksByTitle = bookService.findByTitle("k1");
        for (Book book: booksByTitle) {
            System.out.println("Book found by title: " + book.getTitle());
        }

        //Add authors
        AuthorService authorService = context.getBean(AuthorService.class);
        authorService.add(new Author("name11", "surname11"));
        authorService.add(new Author("name12", "surname21"));
        authorService.add(new Author("name321", "surname321"));

        //Get authors by name
        List<Author> authorsByName = authorService.findByName("e1");
        for (Author author: authorsByName) {
            System.out.println("Authors found by name: " + author.getName()
                    + " " + author.getSurname());
        }
        System.out.println();

        //Authors by name and surname
        List<Author> authorsByNameAndSurname = authorService
                .findByNameAndSurname("e1", "e2");
        for (Author author: authorsByNameAndSurname) {
            System.out.println("Authors found by name and surname: "
                    + author.getName() + " " + author.getSurname());
        }
        System.out.println();

        //Add rents
        Book book1 = new Book("title1", 1923, 1.11);
        Book book2 = new Book("title2", 1632, 2.22);
        User user = new User("user", "userenko", "user@mail.com");
        Rent rent1 = new Rent(LocalDate.now(), user, book1, true);
        Rent rent2 = new Rent(LocalDate.now(), user, book2, false);
        RentService rentService = context.getBean(RentService.class);
        rentService.add(rent1);
        rentService.add(rent2);
        List<Rent> rents = rentService.listRents();
        for (Rent rent: rents) {
            System.out.println("Rent id: " + rent.getId());
            System.out.println("Book: " + rent.getBook().getTitle());
            System.out.println("Rent status: " + rent.isActive());
        }
        System.out.println();

        //LibraryService methods
        LibraryService libraryService = context.getBean(LibraryService.class);
        List<Book> booksRentByUser = libraryService.getBooksRentByUser(user);
        System.out.println("Books rent by user: " + user.getFirstName() + " " + user.getLastName());
        for (Book book: booksRentByUser) {
            System.out.println(book.getTitle());
        }
        System.out.println();
        libraryService.returnBook(user, book1);
        libraryService.rentBook(user, book2);
        libraryService.rentBook(user, book2);
        booksRentByUser = libraryService.getBooksRentByUser(user);
        System.out.println("Books rent by user: "
                + user.getFirstName() + " " + user.getLastName());
        for (Book book: booksRentByUser) {
            System.out.println(book.getTitle());
        }
        System.out.println();
        context.close();
    }
}
