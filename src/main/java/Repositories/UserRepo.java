package Repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import Entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    Optional<User> findUserByFirstNameAndAndLastName(String firstname, String lastname);

}
