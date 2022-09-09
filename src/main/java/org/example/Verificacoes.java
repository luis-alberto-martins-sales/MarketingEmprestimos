package org.example;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Verificacoes {
    EXATAMENTE_OITO_ENTRADAS(ss->ss.length!=8),
    NENHUMA_ENTRADA_VAZIA(ss-> Arrays.stream(ss).anyMatch(s->s.length()==0)),
    FORMATACAO_EMAIL(ss->!ss[3].matches(".+?@.+?\\..+")),
    FORMATACAO_CONTA(ss->!ss[4].matches("\\d+")),
    FORMATACAO_AGENCIA(ss->!ss[5].matches("\\d+"));

    private final Predicate<String[]> predicado;

    Verificacoes(Predicate<String[]> predicado) {
        this.predicado = predicado;
    }

    Boolean test(String[] ss){
        return this.predicado.test(ss);
    }
}
