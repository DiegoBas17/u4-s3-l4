package diegoBasili.exceptions;

import java.util.UUID;

public class NotFoundEx extends RuntimeException {
    public NotFoundEx(UUID eventoId) {
        super("l'evento con id " + eventoId + " non è stato trovato");
    }

}
