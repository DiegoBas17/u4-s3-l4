package diegoBasili;

import diegoBasili.dao.EventoDAO;
import diegoBasili.dao.LocationDAO;
import diegoBasili.dao.PartecipazioneDAO;
import diegoBasili.dao.PersonaDAO;
import diegoBasili.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione degli eventi u4-s3-l4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO sd = new EventoDAO(em);

        Evento cenaDiRitrovo = new Evento("cena", LocalDate.of(2024, 8, 29), "ritrovo con i compagni di classe", TipoEvento.PRIVATO, 20);
        //sd.save(cenaDiRitrovo);
        //Evento eventoFromDb = sd.findById("8aab5955-a387-4b34-883b-37d632168959");

        PersonaDAO pd = new PersonaDAO(em);
        Persona gabriel = new Persona("gabriel", "azafiiri", "gabrielclown", LocalDate.of(1997, 10, 29), Sesso.TANTO);
        pd.save(gabriel);
        //Persona gabrielFromDb = pd.findById("d9914932-1a3a-4671-ad9e-5bc9bb4568b0");

        LocationDAO ld = new LocationDAO(em);
        Location roma = new Location("roma", "roma");
        //ld.save(roma);

        PartecipazioneDAO parted = new PartecipazioneDAO(em);
        //Partecipazione partecipazione = new Partecipazione(gabrielFromDb, eventoFromDb, Stato.CONFERMATO);
        //parted.save(partecipazione);

        PartitaDiCalcio calcetto = new PartitaDiCalcio("calcietto", LocalDate.of(2024, 8, 22), "partita di calcietto", TipoEvento.PUBBLICO, 10, "blu", "rosso", 2, 2, "blu");
        //sd.save(calcetto);

        Concerto caparezza = new Concerto("exuvia", LocalDate.of(2024, 8, 25), "concerto per beneficenza", TipoEvento.PUBBLICO, 2000, Genere.ROCK, Boolean.TRUE);
        //sd.save(caparezza);

        Persona eddy = new Persona("eddy", "turpo", "eddyclown", LocalDate.of(1990, 2, 25), Sesso.TANTO);
        Persona arianna = new Persona("arianna", "loreti", "ariannaclown", LocalDate.of(1990, 2, 25), Sesso.TANTO);
        Persona yuri = new Persona("yuri", "clown", "yuriclown", LocalDate.of(1990, 2, 25), Sesso.TANTO);
        Persona kassi = new Persona("kassandra", "falsitta", "kassiclown", LocalDate.of(1990, 2, 25), Sesso.TANTO);
        pd.save(eddy);
        pd.save(arianna);
        pd.save(yuri);
        pd.save(kassi);


        List<Persona> atleti = new ArrayList<>();
        atleti.add(eddy);
        atleti.add(arianna);
        atleti.add(yuri);
        atleti.add(kassi);
        atleti.add(gabriel);

        GaraDiAtletica tiro_al_piattello = new GaraDiAtletica("olimpiadi", LocalDate.of(2024, 1, 1), "olimpiadi 2024", TipoEvento.PRIVATO, 20, gabriel, atleti);
        sd.save(tiro_al_piattello);
        /*tiro_al_piattello.setSet_persona(atleti);*/
        em.close();
        emf.close();
        System.out.println("Tutto bene fin qua...");
    }

}
