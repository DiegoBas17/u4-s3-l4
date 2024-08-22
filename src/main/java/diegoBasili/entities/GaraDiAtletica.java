package diegoBasili.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "gara_di_atletica")
public class GaraDiAtletica extends Evento {
    @OneToMany
    @JoinColumn(name = "set_persona", nullable = false)
    private List<Persona> set_persona;
    @OneToOne
    @JoinColumn(name = "vincitore", nullable = false)
    private Persona vincitore;

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
