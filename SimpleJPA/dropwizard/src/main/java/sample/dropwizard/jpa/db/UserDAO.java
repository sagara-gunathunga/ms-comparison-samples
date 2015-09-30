package sample.dropwizard.jpa.db;

import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import sample.dropwizard.jpa.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDAO extends AbstractDAO<User> {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public UserDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<User> findUser(Long id) {
        return Optional.fromNullable(get(id));
    }

    public User create(User user) {
        return persist(user);
    }

    public List<User> findUsers() {
        return list(namedQuery("sample.mss.jpa.mode.User.findAll"));
    }
}
