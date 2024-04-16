package SistemaNovaMatriz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Equivalencia {
    private Map<String, String> equivalencias;

    public Equivalencia() {
        this.equivalencias = new HashMap<>();
        carregarEquivalencias();
    }

    private void carregarEquivalencias() {
        String caminhoArquivo = LeitorArquivo.obterCaminhoEquivalencia();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split("=");
                if (partes.length == 2) {
                    String codigo1 = partes[0].trim();
                    String codigo2 = partes[1].trim();
                    equivalencias.put(codigo1, codigo2);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de equivalência: " + e.getMessage());
        }
    }

    public String obterEquivalencia(String codigoDisciplina) {
        return equivalencias.getOrDefault(codigoDisciplina, "N/A");
    }
}
