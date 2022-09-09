package org.example;

import org.example.model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    private final DAO dao;

    public Service(DAO dao) {
        this.dao = dao;
    }

    public List<Cliente> recuperarClientes(){
        return this.dao.lerDados()
                .parallelStream()
                .map(s->s.split("#"))
                .map(this::verificarEntrada)
                .map(this::parsearCliente)
                .collect(Collectors.toList());
    }

    public void salvarDados(List<String> dados) {
        this.dao.salvarDados(dados);
    }

    private Cliente parsearCliente(String[] ss){
        var dados = parsearDadosPessoais(ss);
        var conta = parsearConta(ss);
        var agencia = parsearAgencia(ss);

        return new Cliente(dados,conta,agencia);
    }

    private Agencia parsearAgencia(String[] ss) {
        return new Agencia(ss[5]);
    }

    private Conta parsearConta(String[] ss) {
        return new Conta(ss[4],
                TipoConta.valueOf(ss[6]),
                Boolean.getBoolean(ss[7]));
    }

    private DadosPessoais parsearDadosPessoais(String[] ss) {
        return new DadosPessoais(ss[0], ss[1],
                LocalDate.parse(ss[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                ss[3]);
    }

    private String[] verificarEntrada(String[] entrada){
        if (Arrays.stream(Verificacoes.values())
                .anyMatch(p->p.test(entrada))){
            throw new IllegalArgumentException();
        }

        return entrada;
    }
}
