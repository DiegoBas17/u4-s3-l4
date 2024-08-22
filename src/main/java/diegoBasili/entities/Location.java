package diegoBasili.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue
    private UUID location_id;

    private String name;
    private String city;

    /*COSTRUTTORE VUOTO*/
    public Location() {
    }

    public Location(String city, String name) {
        this.city = city;
        this.name = name;
    }

    public UUID getId() {
        return location_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
