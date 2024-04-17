package SistemaNovaMatriz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TratadorMatriz {
    public static void main(String[] args) {
        exibirMatriz();
    }
    private static List<Matriz> lerMatrizes() throws IOException {
        List<Matriz> matrizes = new ArrayList<>();

        String caminhoMatriz1 = LeitorArquivo.obterCaminhoMatriz1();
        String conteudoMatriz1 = LeitorArquivo.lerConteudoArquivo(caminhoMatriz1);
        Matriz matriz1 = criarMatrizAPartirDoArquivo(conteudoMatriz1);
        matrizes.add(matriz1);

        String caminhoMatriz2 = LeitorArquivo.obterCaminhoMatriz2();
        String conteudoMatriz2 = LeitorArquivo.lerConteudoArquivo(caminhoMatriz2);
        Matriz matriz2 = criarMatrizAPartirDoArquivo(conteudoMatriz2);
        matrizes.add(matriz2);

        return matrizes;
    }

    private static Matriz criarMatrizAPartirDoArquivo(String conteudoArquivo) {
        // Inicializar variáveis para armazenar informações da matriz
        int ano = 0;
        int codigo = 0;
        String nomeCurso = null;
        NivelCurso nivelCurso = null;
        List<Disciplina> disciplinasMatrizes = new ArrayList<>();

        // Dividir o conteúdo do arquivo em linhas
        String[] linhas = conteudoArquivo.split("\n");

        boolean iniciouDisciplinas = false;

        // Iterar sobre as linhas do arquivo
        for (String linha : linhas) {
            // Dividir cada linha em partes separadas por ":"
            String[] partes = linha.split(":");
            if (partes.length != 2) {
                // Ignorar linhas mal formatadas
                continue;
            }
            // Extrair o nome do atributo e o valor correspondente
            String atributo = partes[0].trim().toLowerCase(); // Converter para minúsculas para evitar problemas de maiúsculas/minúsculas
            String valor = partes[1].trim();

            // Verificar e atribuir os valores aos atributos da matriz
            switch (atributo) {
                case "ano":
                    ano = Integer.parseInt(valor);
                    break;
                case "codigo":
                    codigo = Integer.parseInt(valor);
                    break;
                case "nomecurso":
                    nomeCurso = valor;
                    break;
                case "nivelcurso":
                    nivelCurso = NivelCurso.valueOf(valor);
                    break;
                case "disciplinas":
                    iniciouDisciplinas = true;
                    continue; // Continue para evitar que a linha "disciplinasMatrizes=" seja processada como uma disciplina
                default:
                    // Se o atributo for desconhecido, ignorar
                    break;
            }

            // Se já iniciou as disciplinasMatrizes, adicionar cada linha como uma disciplina até encontrar uma linha em branco ou o fim do arquivo
            if (iniciouDisciplinas) {
                    disciplinasMatrizes.add(new Disciplina(partes[0], partes[1], 0));
            }
        }

        // Criar e retornar a matriz com as informações coletadas
        return new Matriz(ano, codigo, nomeCurso, disciplinasMatrizes, nivelCurso);
    }
    public static void exibirMatriz() {
        try {
            List<Matriz> matrizes = TratadorMatriz.lerMatrizes();
            for (Matriz matriz : matrizes) {
                System.out.println("Matriz:");
                System.out.println("Ano: " + matriz.getAno());
                System.out.println("Código: " + matriz.getCodigoMatriz());
                System.out.println("Nome do Curso: " + matriz.getNomeCurso());
                System.out.println("Nível do Curso: " + matriz.getNivelCurso());
                System.out.println("Disciplinas:");
                for (Disciplina disciplina : matriz.getDisciplinas()) {
                    System.out.println("- Código: " + disciplina.getCodigo() + ", Nome: " + disciplina.getNome());
                }
                System.out.println("-----------------------------------------");
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace(); // Isso imprime o rastreamento completo da exceção para ajudar na depuração
        }
    }
}
