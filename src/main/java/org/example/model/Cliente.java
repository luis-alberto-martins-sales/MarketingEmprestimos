package org.example.model;

import java.util.Objects;

public class Cliente {
    private final DadosPessoais dados;
    private final Conta conta;
    private final Agencia agencia;

    public Cliente(DadosPessoais dados, Conta conta, Agencia agencia) {
        this.dados = dados;
        this.conta = conta;
        this.agencia = agencia;
    }

    public Conta getConta() {
        return conta;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dados=" + dados +
                ", conta=" + conta +
                ", agencia=" + agencia +
                '}';
    }

    public DadosPessoais getDados() {
        return dados;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return dados.equals(cliente.dados) && conta.equals(cliente.conta) && agencia.equals(cliente.agencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dados, conta, agencia);
    }
}
