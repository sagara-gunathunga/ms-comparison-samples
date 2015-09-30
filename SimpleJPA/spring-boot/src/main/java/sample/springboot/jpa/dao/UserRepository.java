package sample.springboot.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import sample.springboot.jpa.core.User;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
}
