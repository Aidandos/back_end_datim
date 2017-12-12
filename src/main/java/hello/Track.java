package hello;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

    @ElementCollection
    @Column(name="latitudes")
    private List<Double> latitudes;

    @ElementCollection
    @Column(name="longitudes")
    private List<Double> longitudes;

    @ElementCollection
    private Map<Long, Double> ranking;

    //@OneToOne
    //private List<Pair> gpsCoordinates;

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


//    public List<Pair> getGpsCoordinates() {
//        return gpsCoordinates;
//    }
//
//    public void setGpsCoordinates(List<Pair> gpsCoordinates) {
//        this.gpsCoordinates = gpsCoordinates;
//    }
}
