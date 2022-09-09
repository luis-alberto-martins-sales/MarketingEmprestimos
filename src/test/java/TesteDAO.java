import org.example.DAO;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TesteDAO {
    @Test
    public void deveSalvarArquivo(){
        Path path = Path.of("teste.txt");
        var dao = new DAO(path);

        dao.salvarDados(List.of());

        Assert.assertTrue(path.toFile().exists());
    }

    @Test
    public void deveLerArquivoSalvo(){
        Path path = Path.of("teste.txt");
        var dao = new DAO(path);
        var textoTeste = List.of("teste");
        dao.salvarDados(textoTeste);

        try {
            Assert.assertEquals(Files.readAllLines(path), dao.lerDados());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void naoDeveLerArquivoInexistente(){
        Path path = Path.of("testeInexistente.txt");
        var dao = new DAO(path);

        if (path.toFile().exists()){
            throw new IllegalStateException("Arquivo a ser testado não pode existir.");
        }

        Assert.assertThrows(RuntimeException.class, dao::lerDados);

    }


}
