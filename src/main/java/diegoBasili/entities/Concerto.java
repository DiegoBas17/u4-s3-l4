package diegoBasili.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("concerto")
public class Concerto extends Evento {
    @Enumerated(EnumType.STRING)
    private Genere genere;
    private Boolean in_streaming;

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, long numeroMassimoPartecipanti, Genere genere, Boolean in_streaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.in_streaming = in_streaming;
        this.genere = genere;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public Boolean getIn_streaming() {
        return in_streaming;
    }

    public void setIn_streaming(Boolean in_streaming) {
        this.in_streaming = in_streaming;
    }
}
