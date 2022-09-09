package org.example;

import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var dao = new DAO(Path.of("dadosClientes.txt"));
        var service = new Service(dao);

//        1 - Escreva os dados em um arquivo.
        service.salvarDados(recuperarFolhaFisica());

//        2 - Depois disso você deve ler os dados do arquivo criado e
//        fazer a transformação para uma lista de Cliente.
        var clientes = service.recuperarClientes();

        clientes.stream()
//        3 - Filtrar para ver quais clientes ainda não possuem empréstimos.
                .filter(c->!c.getConta().getPossuiEmprestimo())
//        4 - Imprimir as informações, pensando em alta performance,
//        você pode pensar em utilizar algo com paralelismo.
                .parallel()
                .forEach(System.out::println);
    }

    private static  List<String> recuperarFolhaFisica() {
        return List.of(
                "Anderson#Piotto#12/03/1985#piottok10@gmail.com#062264#458#CORRENTE#FALSE",
                "Mateus#Jose#19/12/1986#mateus@gmail.com#4514545#045#POUPANCA#TRUE",
                "Paulo#Tarso#24/03/2000#paulo@gmail.com#056234#478#CORRENTE#FALSE",
                "Vitor#De Paula#13/04/1987#vitor@gmail.com#5875#578#POUPANCA#TRUE",
                "Josefa#Farias#12/10/1985#josefa@gmail.com#57577#542#CORRENTE#FALSE",
                "Juracy#Miranda#14/09/1986#juracy@gmail.com#678686#875#POUPANCA#TRUE",
                "Fran#Leite#19/08/1960#fran@gmail.com#645645#577#CORRENTE#FALSE",
                "Fernando#Castanon#01/02/1980#fernando@gmail.com#456456#578#POUPANCA#TRUE",
                "Raquel#Branca#03/01/1983#raquel@gmail.com#54345345#147#CORRENTE#FALSE",
                "Benjamim#Jacob#09/03/1991#benjamim@gmail.com#147285#147#POUPANCA#TRUE",
                "Isabela#Celeste#12/02/1998#isabela@gmail.com#3696322#575#CORRENTE#FALSE",
                "Lilian#De Ale#25/01/2003#lilian@gmail.com#1475285#141#POUPANCA#TRUE",
                "Liliane#Theosidora#12/07/1999#liliane@gmail.com#76542#475#CORRENTE#FALSE",
                "Luciana#Piotta#27/10/1986#luciana@gmail.com#281787#585#POUPANCA#TRUE",
                "Caio#Sorridonte#13/11/1985#caio@gmail.com#17585#575#CORRENTE#FALSE",
                "Murilo#Corin#14/12/1983#murilo@gmail.com#75375375#575#POUPANCA#TRUE",
                "Jennifer#Vitoria#03/07/1981#jennifer@gmail.com#3614752#575#CORRENTE#FALSE",
                "Wellington#Decidorio#18/11/1971#wellington@gmail.com#175278#7575#POUPANCA#TRUE");
    }

}