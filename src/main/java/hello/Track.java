package hello;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.stream.Location;

/**
 * Created by timon on 06.12.2017.
 */

@Entity
public class Track {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private String name;

    @OneToMany//(fetch = FetchType.EAGER)
    private List<Location> gpsCoordinates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Location> getGpsCoordinates() {
        return gpsCoordinates;
    }

    public void setGpsCoordinates(List<Location> gpsCoordinates) {
        this.gpsCoordinates = gpsCoordinates;
    }
}
