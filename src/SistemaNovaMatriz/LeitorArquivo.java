package SistemaNovaMatriz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivo {
    public static List<String> lerHistoricoAcademico(String caminhoArquivo) {
        List<String> disciplinasAprovadas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                // Verificar se a linha contém informações de disciplina aprovada
                if (linha.contains("Aprovado")) {
                    disciplinasAprovadas.add(linha);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return disciplinasAprovadas;
    }
}
