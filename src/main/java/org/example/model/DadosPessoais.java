package org.example.model;

import java.time.LocalDate;
import java.util.Objects;

public class DadosPessoais {
    private final String nome;
    private final String sobrenome;
    private final LocalDate dataNascimento;
    private final String email;

    public DadosPessoais(String nome, String sobrenome, LocalDate dataNascimento, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    @Override
    public String toString() {
        return "DadosPessoais{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DadosPessoais that = (DadosPessoais) o;
        return nome.equals(that.nome) && sobrenome.equals(that.sobrenome) && dataNascimento.equals(that.dataNascimento) && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sobrenome, dataNascimento, email);
    }
}
