package SistemaNovaMatriz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class HistoricoAcademico {

    public static void main(String[] args) {
        String caminho = LeitorArquivo.obterCaminhoArquivo();
        lerArquivo(caminho);
    }

    private static void lerArquivo(String caminho) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;

            boolean iniciouDisciplinas = false;

            while ((linha = br.readLine()) != null) {

                if (linha.contains("Disciplinas cursadas na matriz curricular:")) {

                    iniciouDisciplinas = true;
                    continue;
                }
                if (iniciouDisciplinas && !linha.trim().isEmpty()) {
                    if (linha.contains("Aprovado")) {
                        String[] partes = linha.split("\\s+");
                        String codigo = partes[2];
                        String discplina = "";
                        for (int i=3; i<partes.length; i++){

                            if (!partes[i].equals("OBR")) {
                                discplina=discplina.concat(" ");
                                discplina=discplina.concat(partes[i]);

                            }else {
                                break;
                            }
                        }
                        System.out.println(codigo + "\t" + discplina);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}