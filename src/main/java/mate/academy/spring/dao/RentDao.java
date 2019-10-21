package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;

public interface RentDao {
    void add(Rent rent);

    Optional<Rent> get(User user, Book book);

    void update(Rent rent);

    List<Rent> listRents();

    List<Rent> getActiveRentsByUser(User user);
}
