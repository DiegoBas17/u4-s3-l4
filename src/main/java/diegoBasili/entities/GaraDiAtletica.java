package diegoBasili.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "gara_di_atletica")
public class GaraDiAtletica extends Evento {
    @ManyToMany
    @JoinColumn(name = "set_persona")
    private List<Persona> set_persona;
    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, long numeroMassimoPartecipanti, Persona vincitore, List<Persona> set_persona) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.vincitore = vincitore;
        this.set_persona = set_persona;
    }

    public GaraDiAtletica(Persona vincitore, List<Persona> set_persona) {
        this.vincitore = vincitore;
        this.set_persona = set_persona;
    }

    public List<Persona> getSet_persona() {
        return set_persona;
    }

    public void setSet_persona(List<Persona> set_persona) {
        this.set_persona = set_persona;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
