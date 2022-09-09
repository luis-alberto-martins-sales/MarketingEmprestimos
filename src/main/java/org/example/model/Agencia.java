package org.example.model;

import java.util.Objects;

public class Agencia {
    private final String numero;

    public Agencia(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "numero=" + numero +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agencia agencia = (Agencia) o;
        return numero.equals(agencia.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
