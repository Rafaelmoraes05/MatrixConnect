package SistemaNovaMatriz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TratadorMatriz {
    public static void main(String[] args) {
            try {
                // Ler o conteúdo do arquivo da matriz 1
                String caminhoMatriz1 = LeitorArquivo.obterCaminhoMatriz1();
                String conteudoMatriz1 = LeitorArquivo.lerConteudoArquivo(caminhoMatriz1);
                Matriz matriz1 = criarMatrizAPartirDoArquivo(conteudoMatriz1);
                System.out.println("Matriz 1");
                exibirMatriz(matriz1);

                // Exibir um separador entre as matrizes
                System.out.println("-----------------------------------------");

                // Ler o conteúdo do arquivo da matriz 2
                String caminhoMatriz2 = LeitorArquivo.obterCaminhoMatriz2();
                String conteudoMatriz2 = LeitorArquivo.lerConteudoArquivo(caminhoMatriz2);
                Matriz matriz2 = criarMatrizAPartirDoArquivo(conteudoMatriz2);
                System.out.println("Matriz 2");
                exibirMatriz(matriz2);
            } catch (IOException e) {
                System.err.println("Erro ao ler o arquivo: " + e.getMessage());
                e.printStackTrace(); // Isso imprime o rastreamento completo da exceção para ajudar na depuração
            }
        }

    private static Matriz criarMatrizAPartirDoArquivo(String conteudoArquivo) {
        // Inicializar variáveis para armazenar informações da matriz
        int ano = 0;
        int codigo = 0;
        String nomeCurso = null;
        NivelCurso nivelCurso = null;
        List<Disciplina> disciplinas = new ArrayList<>();

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
                    continue; // Continue para evitar que a linha "disciplinas=" seja processada como uma disciplina
                default:
                    // Se o atributo for desconhecido, ignorar
                    break;
            }

            // Se já iniciou as disciplinas, adicionar cada linha como uma disciplina até encontrar uma linha em branco ou o fim do arquivo
            if (iniciouDisciplinas) {
                    disciplinas.add(new Disciplina(partes[0], partes[1], 0));
            }
        }

        // Criar e retornar a matriz com as informações coletadas
        return new Matriz(ano, codigo, nomeCurso, disciplinas, nivelCurso);
    }

    private static void exibirMatriz(Matriz matriz) {
        System.out.println("Ano: " + matriz.getAno());
        System.out.println("Código: " + matriz.getCodigoMatriz());
        System.out.println("Nome do Curso: " + matriz.getNomeCurso());
        System.out.println("Nível do Curso: " + matriz.getNivelCurso());
        System.out.println("Disciplinas:");
        for (Disciplina disciplina : matriz.getDisciplinas()) {
            System.out.println("- Código: " + disciplina.getCodigo() + ", Nome: " + disciplina.getNome() + ", Carga Horária: " + disciplina.getCargaHoraria());
        }
    }
}