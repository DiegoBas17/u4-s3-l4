package diegoBasili.dao;

import diegoBasili.entities.Evento;
import diegoBasili.exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
// 1. Chiediamo all'entity manager di fornirci una transazione
        EntityTransaction transaction = em.getTransaction();

        // 2. Facciamo partire la transazione
        transaction.begin();

        // 3. Aggiungiamo lo studente al Persistence Context (a questo step lo studente non è ancora salvato a db)
        em.persist(evento);

        // 4. Concludiamo la transazione (qua lo studente verrà effettivamente salvato)
        transaction.commit();
    }

    public Evento findById(String id) throws NotFoundEx {
        Evento evento = em.find(Evento.class, UUID.fromString(id));
        if (evento == null) {
            throw new NotFoundEx(UUID.fromString(id));
        }
        return evento;
    }

    public void findByIdAndDelete(String id) throws NotFoundEx {
        Evento evento = findById(id);
        em.getTransaction().begin();
        em.remove(evento);
        em.getTransaction().commit();
    }
}
