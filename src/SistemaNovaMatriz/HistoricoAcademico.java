package SistemaNovaMatriz;

import java.util.List;
import java.util.Scanner;

public class HistoricoAcademico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o caminho do arquivo de histórico acadêmico:");
        String caminhoArquivo = scanner.nextLine();

        List<String> disciplinasAprovadas = LeitorArquivo.lerHistoricoAcademico(caminhoArquivo);

        // Exibir disciplinas aprovadas
        System.out.println("Disciplinas Aprovadas:");
        for (String disciplina : disciplinasAprovadas) {
            System.out.println(disciplina);
        }

        scanner.close();
    }

}
