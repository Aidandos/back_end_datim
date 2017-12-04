package hello;

/**
 * Created by timon on 04.12.2017.
 */
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
    User findByUsername(String username);
    User findByToken(String token);
}
