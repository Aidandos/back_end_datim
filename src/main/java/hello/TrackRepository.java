package hello;

/**
 * Created by timon on 04.12.2017.
 */
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository("trackRepository")
public interface TrackRepository extends CrudRepository<Track, Long> {
    Track findByName(String name);
}