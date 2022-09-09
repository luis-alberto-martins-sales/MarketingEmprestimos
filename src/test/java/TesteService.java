import org.example.DAO;
import org.example.Service;
import org.example.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class TesteService {

    @Test
    public void deveRecuperarClienteSalvo(){
        Path path = Path.of("teste.txt");
        var dao = new DAO(path);
        var service = new Service(dao);
        var textoTeste = List.of("Anderson#" +
                "Piotto#" +
                "12/03/1985#" +
                "piottok10@gmail.com#" +
                "062264#" +
                "458#" +
                "CORRENTE#" +
                "FALSE");
        service.salvarDados(textoTeste);

        var dadosTeste = new DadosPessoais("Anderson","Piotto",
                LocalDate.of(1985,3,12),"piottok10@gmail.com");
        var contaTeste = new Conta("062264", TipoConta.CORRENTE,false);
        var agenciaTeste = new Agencia("458");
        var clienteTeste = new Cliente(dadosTeste,contaTeste,agenciaTeste);

        Assert.assertEquals(clienteTeste,service.recuperarClientes().get(0));
        Assert.assertEquals(clienteTeste.hashCode(),service.recuperarClientes().get(0).hashCode());
        Assert.assertEquals(clienteTeste.getConta().hashCode(),service.recuperarClientes().get(0).getConta().hashCode());
        Assert.assertEquals(clienteTeste.getAgencia().hashCode(),service.recuperarClientes().get(0).getAgencia().hashCode());
        Assert.assertEquals(clienteTeste.getDados().hashCode(),service.recuperarClientes().get(0).getDados().hashCode());
    }

    @Test
    public void naoDeveRecuperarClienteComDadoFaltante(){
        Path path = Path.of("teste.txt");
        var dao = new DAO(path);
        var service = new Service(dao);
        var textoTeste = List.of("Anderson#" +
                "Piotto#" +
                "12/03/1985#" +
//                "piottok10@gmail.com#" +
                "062264#" +
                "458#" +
                "CORRENTE#" +
                "FALSE");
        service.salvarDados(textoTeste);

        Assert.assertThrows(IllegalArgumentException.class, service::recuperarClientes);
    }

    @Test
    public void naoDeveRecuperarClienteComDadoVazio(){
        Path path = Path.of("teste.txt");
        var dao = new DAO(path);
        var service = new Service(dao);
        var textoTeste = List.of("Anderson#" +
                "Piotto#" +
                "12/03/1985#" +
                "piottok10@gmail.com#" +
                "062264#" +
//                -------------------
                "#" +
//                -------------------
                "CORRENTE#" +
                "FALSE");
        service.salvarDados(textoTeste);

        Assert.assertThrows(IllegalArgumentException.class, service::recuperarClientes);
    }

    @Test
    public void naoDeveRecuperarClienteComEmailInconsistente(){
        Path path = Path.of("teste.txt");
        var dao = new DAO(path);
        var service = new Service(dao);
        var textoTeste = List.of("Anderson#" +
                "Piotto#" +
                "12/03/1985#" +
//                -------------------
                "@#" +
//                -------------------
                "062264#" +
                "458#" +
                "CORRENTE#" +
                "FALSE");
        service.salvarDados(textoTeste);

        Assert.assertThrows(IllegalArgumentException.class, service::recuperarClientes);
    }

    @Test
    public void naoDeveRecuperarClienteComNumeroDeAgenciaInconsistente(){
        Path path = Path.of("teste.txt");
        var dao = new DAO(path);
        var service = new Service(dao);
        var textoTeste = List.of("Anderson#" +
                "Piotto#" +
                "12/03/1985#" +
                "piottok10@gmail.com#" +
                "062264#" +
//                -------------------
                "*458#" +
//                -------------------
                "CORRENTE#" +
                "FALSE");
        service.salvarDados(textoTeste);

        Assert.assertThrows(IllegalArgumentException.class, service::recuperarClientes);
    }

    @Test
    public void naoDeveRecuperarClienteComNumeroDeContaInconsistente(){
        Path path = Path.of("teste.txt");
        var dao = new DAO(path);
        var service = new Service(dao);
        var textoTeste = List.of("Anderson#" +
                "Piotto#" +
                "12/03/1985#" +
                "piottok10@gmail.com#" +
//                -------------------
                "0622%64#" +
//                -------------------
                "458#" +
                "CORRENTE#" +
                "FALSE");
        service.salvarDados(textoTeste);

        Assert.assertThrows(IllegalArgumentException.class, service::recuperarClientes);
    }
}
