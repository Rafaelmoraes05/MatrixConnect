package SistemaNovaMatriz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TratadorEquivalencia {
    public static void main(String[] args) {
        List<Equivalencia> equivalencias = lerEquivalencias();
        exibirEquivalencias(equivalencias);
    }

    public static List<Equivalencia> lerEquivalencias() {
        List<Equivalencia> equivalencias = new ArrayList<>();
        try {
            String caminhoEquivalencia = LeitorArquivo.obterCaminhoEquivalencia();
            String conteudoEquivalencia = LeitorArquivo.lerConteudoArquivo(caminhoEquivalencia);
            String[] linhas = conteudoEquivalencia.split("\n");
            for (String linha : linhas) {
                String[] partes = linha.split("=");
                if (partes.length == 2) {
                    String[] codigoMatriz1Partes = partes[0].split("\\|");
                    String[] codigoMatriz2Partes = partes[1].split("\\|");
                    if (codigoMatriz1Partes.length == 3 && codigoMatriz2Partes.length == 3) {
                        int codigoMatriz1 = Integer.parseInt(codigoMatriz1Partes[1]);
                        String codigoDisciplina1 = codigoMatriz1Partes[2];
                        int codigoMatriz2 = Integer.parseInt(codigoMatriz2Partes[1]);
                        String codigoDisciplina2 = codigoMatriz2Partes[2];
                        Equivalencia equivalencia = new Equivalencia(codigoMatriz1, codigoDisciplina1, codigoMatriz2, codigoDisciplina2);
                        equivalencias.add(equivalencia);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de equivalência: " + e.getMessage());
            e.printStackTrace(); // Isso imprime o rastreamento completo da exceção para ajudar na depuração
        }
        return equivalencias;
    }

    private static void exibirEquivalencias(List<Equivalencia> equivalencias) {
        if (equivalencias.isEmpty()) {
            System.out.println("Nenhuma equivalência encontrada.");
        } else {
            System.out.println("Equivalências:");
            for (Equivalencia equivalencia : equivalencias) {
                System.out.println("- Matriz " + equivalencia.getCodigoMatriz1() + ", Disciplina " + equivalencia.getCodigoDisciplina1() +
                        " é equivalente a Matriz " + equivalencia.getCodigoMatriz2() + ", Disciplina " + equivalencia.getCodigoDisciplina2());
            }
        }
    }
}
