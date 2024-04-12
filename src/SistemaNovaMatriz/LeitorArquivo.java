package SistemaNovaMatriz;

import java.util.Scanner;

public class LeitorArquivo {
    public static String obterCaminhoArquivo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o caminho do arquivo:");
        return scanner.nextLine();
    }

    public static String obterCaminhoMatriz1() {
        return "Matriz1.txt";
    }

    public static String obterCaminhoMatriz2() {
        return "Matriz2.txt";
    }

    public static String obterCaminhoEquivalencia(){
        return "Equivalencia.txt";
    }

}
