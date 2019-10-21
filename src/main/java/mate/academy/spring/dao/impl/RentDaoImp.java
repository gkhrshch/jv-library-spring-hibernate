package mate.academy.spring.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import mate.academy.spring.dao.RentDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RentDaoImp implements RentDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Rent rent) {
        sessionFactory.getCurrentSession().save(rent);
    }

    @Override
    public Optional<Rent> get(User user, Book book) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("FROM Rent WHERE user_id=:user AND book_id=:book");
        query.setParameter("user", user.getId());
        query.setParameter("book", book.getId());
        return Optional.ofNullable((Rent) query.getSingleResult());
    }

    @Override
    public void update(Rent rent) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE Rent SET active = false WHERE id = :id");
        query.setParameter("id", rent.getId());
        query.executeUpdate();
    }

    @Override
    public List<Rent> listRents() {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Rent", Rent.class);
        return query.getResultList();
    }

    @Override
    public List<Rent> getActiveRentsByUser(User user) {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Rent WHERE user_id=:user AND active=:true", Rent.class);
        query.setParameter("user", user.getId());
        query.setParameter("true", true);
        return query.getResultList();
    }
}
