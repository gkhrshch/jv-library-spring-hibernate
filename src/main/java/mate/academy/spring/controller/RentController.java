package mate.academy.spring.controller;

import java.util.List;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.LibraryService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rent")
public class RentController {
    private static final Long USER_ID = 1L;

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping("/rents")
    public String getBooksRentByUser(Model model) {
        User user = userService.get(1L);
        List<Book> booksRentByUser = libraryService.getBooksRentByUser(user);
        model.addAttribute("rentBooks", booksRentByUser);
        return "rent/rentInfo";
    }

    @GetMapping("/rentbook")
    public String rentBook(@RequestParam("book_id") Long bookId, Model model) {
        User user = userService.get(1L);
        Book book = bookService.get(bookId);
        Rent rent = libraryService.rentBook(user, book);
        model.addAttribute("rent", rent);
        return getBooksRentByUser(model);
    }

    @GetMapping("/returnbook")
    public String returnBook(@RequestParam("book_id") Long bookId, Model model) {
        User user = userService.get(1L);
        Book book = bookService.get(bookId);
        libraryService.returnBook(user, book);
        return getBooksRentByUser(model);
    }
}
