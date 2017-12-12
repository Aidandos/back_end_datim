package hello;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by timon on 12.12.2017.
 */

public interface ActivityRepository extends CrudRepository<Activity, Long> {
    Track findByName(String name);
}
