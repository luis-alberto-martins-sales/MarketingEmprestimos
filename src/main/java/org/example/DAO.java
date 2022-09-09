package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DAO {
    private final Path path;

    public DAO(Path path) {
        this.path = path;
    }

    public List<String> lerDados() {
        try {
            return Files.readAllLines(this.path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void salvarDados(List<String> dadosClientes) {
        try {
            Files.write(this.path, dadosClientes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
