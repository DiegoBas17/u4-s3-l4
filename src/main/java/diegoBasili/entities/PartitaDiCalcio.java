package diegoBasili.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("partita_di_calcio")
public class PartitaDiCalcio extends Evento {
    private String squadra_di_casa;
    private String squadra_ospite;
    private String squadra_vincente;
    private int gol_sq_casa;
    private int gol_sq_ospite;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, long numeroMassimoPartecipanti, String squadra_di_casa, String squadra_ospite, int gol_sq_ospite, int gol_sq_casa, String squadra_vincente) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.squadra_di_casa = squadra_di_casa;
        this.squadra_ospite = squadra_ospite;
        this.squadra_vincente = squadra_vincente;
        this.gol_sq_ospite = gol_sq_ospite;
        this.gol_sq_casa = gol_sq_casa;

    }

    public String getSquadra_di_casa() {
        return squadra_di_casa;
    }

    public void setSquadra_di_casa(String squadra_di_casa) {
        this.squadra_di_casa = squadra_di_casa;
    }

    public String getSquadra_ospite() {
        return squadra_ospite;
    }

    public void setSquadra_ospite(String squadra_ospite) {
        this.squadra_ospite = squadra_ospite;
    }

    public String getSquadra_vincente() {
        return squadra_vincente;
    }

    public void setSquadra_vincente(String squadra_vincente) {
        this.squadra_vincente = squadra_vincente;
    }

    public int getGol_sq_casa() {
        return gol_sq_casa;
    }

    public void setGol_sq_casa(int gol_sq_casa) {
        this.gol_sq_casa = gol_sq_casa;
    }

    public int getGol_sq_ospite() {
        return gol_sq_ospite;
    }

    public void setGol_sq_ospite(int gol_sq_ospite) {
        this.gol_sq_ospite = gol_sq_ospite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadra_di_casa='" + squadra_di_casa + '\'' +
                ", squadra_ospite='" + squadra_ospite + '\'' +
                ", squadra_vincente='" + squadra_vincente + '\'' +
                ", gol_sq_casa=" + gol_sq_casa +
                ", gol_sq_ospite=" + gol_sq_ospite +
                '}';
    }
}
