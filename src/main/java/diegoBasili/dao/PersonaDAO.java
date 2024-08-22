package diegoBasili.dao;


import diegoBasili.entities.Persona;
import diegoBasili.exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();
    }

    public Persona findById(String id) throws NotFoundEx {
        Persona persona = em.find(Persona.class, UUID.fromString(id));
        if (persona == null) {
            throw new NotFoundEx(UUID.fromString(id));
        }
        return persona;
    }

    public void findByIdAndDelete(String id) throws NotFoundEx {
        Persona persona = findById(id);
        em.getTransaction().begin();
        em.remove(persona);
        em.getTransaction().commit();
    }
}
