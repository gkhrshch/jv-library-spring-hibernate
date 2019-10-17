package mate.academy.spring.service.impl;

import java.util.List;
import mate.academy.spring.dao.BookDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    private BookDao bookDao;

    @Transactional
    public void add(Book book) {
        bookDao.add(book);
    }

    @Transactional
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }
}