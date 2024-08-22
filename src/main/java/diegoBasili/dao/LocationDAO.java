package diegoBasili.dao;

import diegoBasili.entities.Location;
import diegoBasili.exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
    }

    public Location findById(String id) throws NotFoundEx {
        Location location = em.find(Location.class, UUID.fromString(id));
        if (location == null) {
            throw new NotFoundEx(UUID.fromString(id));
        }
        return location;
    }

    public void findByIdAndDelete(String id) throws NotFoundEx {
        Location location = findById(id);
        em.getTransaction().begin();
        em.remove(location);
        em.getTransaction().commit();
    }
}
