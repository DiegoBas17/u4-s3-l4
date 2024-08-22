package diegoBasili.dao;

import diegoBasili.entities.Partecipazione;
import diegoBasili.exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
    }

    public Partecipazione findById(String id) throws NotFoundEx {
        Partecipazione partecipazione = em.find(Partecipazione.class, UUID.fromString(id));
        if (partecipazione == null) {
            throw new NotFoundEx(UUID.fromString(id));
        }
        return partecipazione;
    }

    public void findByIdAndDelete(String id) throws NotFoundEx {
        Partecipazione partecipazione = findById(id);
        em.getTransaction().begin();
        em.remove(partecipazione);
        em.getTransaction().commit();
    }
}
