package SistemaNovaMatriz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class LeitorArquivo {
    public static String obterCaminhoArquivo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o caminho do arquivo:");
        return scanner.nextLine();
    }

    public static String obterCaminhoMatriz1() {
        return "./MatrixConnect/Matriz1.txt";
    }

    public static String obterCaminhoMatriz2() {
        return "./MatrixConnect/Matriz2.txt";
    }

    public static String obterCaminhoEquivalencia(){
        return "./MatrixConnect/Equivalencia.txt";
    }

    /*Teste, remover depois */
    public static String obeterCaminhoHistorico(){
        return "./MatrixConnect/historico.txt";
    }


    public static String lerConteudoArquivo(String caminhoArquivo) throws IOException {
        List<String> linhas = Files.readAllLines(Paths.get(caminhoArquivo));
        StringBuilder conteudo = new StringBuilder();
        for (String linha : linhas) {
            conteudo.append(linha).append("\n");
        }
        return conteudo.toString();
    }

}
