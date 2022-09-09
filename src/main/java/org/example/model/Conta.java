package org.example.model;

import java.util.Objects;

public class Conta {
    private final String numero;
    private final TipoConta tipoConta;
    private final Boolean possuiEmprestimo;

    public Conta(String numero, TipoConta tipoConta, Boolean possuiEmprestimo) {
        this.numero = numero;
        this.tipoConta = tipoConta;
        this.possuiEmprestimo = possuiEmprestimo;
    }

    public Boolean getPossuiEmprestimo() {
        return possuiEmprestimo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", tipoConta=" + tipoConta +
                ", possuiEmprestimo=" + possuiEmprestimo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return numero.equals(conta.numero) && tipoConta == conta.tipoConta && possuiEmprestimo.equals(conta.possuiEmprestimo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, tipoConta, possuiEmprestimo);
    }
}
