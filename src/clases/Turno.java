package clases;

import java.util.UUID;

public class Turno {
    private UUID id;
    private char tipo;
    private int tiempoEstimado;

    public Turno(UUID id, Character tipo, int tiempoEstimado) {
        this.id = id;
        this.tipo = tipo;
        this.tiempoEstimado = tiempoEstimado;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }
}
