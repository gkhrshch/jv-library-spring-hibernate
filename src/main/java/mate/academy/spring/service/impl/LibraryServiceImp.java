package mate.academy.spring.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import mate.academy.spring.dao.RentDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibraryServiceImp implements LibraryService {
    @Autowired
    private RentDao rentDao;

    @Transactional
    @Override
    public Rent rentBook(User user, Book book) {
        Rent rent = new Rent(LocalDate.now(), user, book, true);
        rentDao.add(rent);
        return rent;
    }

    @Transactional
    @Override
    public void returnBook(User user, Book book) {
        Rent rent = rentDao.get(user, book).get();
        rent.setActive(false);
        rentDao.update(rent);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getBooksRentByUser(User user) {
        List<Book> booksRentByUser = new ArrayList<>();
        for (Rent rent: rentDao.getActiveRentsByUser(user)) {
            booksRentByUser.add(rent.getBook());
        }
        return booksRentByUser;
    }
}
