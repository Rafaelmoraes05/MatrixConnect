package SistemaNovaMatriz;

import java.util.Scanner;

public class LeitorArquivo {
    public static String obterCaminhoArquivo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o caminho do arquivo:");
        return scanner.nextLine();
    }
}
