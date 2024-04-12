package SistemaNovaMatriz;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Ler o conteúdo do arquivo da matriz 1
        String caminhoMatriz1 = LeitorArquivo.obterCaminhoMatriz1();
        Matriz matriz1 = criarMatrizAPartirDoArquivo(caminhoMatriz1);
        System.out.println("Matriz 1");
        exibirMatriz(matriz1);

        // Exibir um separador entre as matrizes
        System.out.println("-----------------------------------------");

        // Ler o conteúdo do arquivo da matriz 2
        String caminhoMatriz2 = LeitorArquivo.obterCaminhoMatriz2();
        Matriz matriz2 = criarMatrizAPartirDoArquivo(caminhoMatriz2);
        System.out.println("Matriz 2:");
        exibirMatriz(matriz2);
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

        // Iterar sobre as linhas do arquivo
        for (String linha : linhas) {
            // Dividir cada linha em partes separadas por ":"
            String[] partes = linha.split(":");
            if (partes.length != 2) {
                // Ignorar linhas mal formatadas
                continue;
            }
            // Extrair o nome do atributo e o valor correspondente
            String atributo = partes[0].trim();
            String valor = partes[1].trim();

            // Verificar e atribuir os valores aos atributos da matriz
            switch (atributo) {
                case "ano":
                    ano = Integer.parseInt(valor);
                    break;
                case "codigo":
                    codigo = Integer.parseInt(valor);
                    break;
                case "nomeCurso":
                    nomeCurso = valor;
                    break;
                case "nivelCurso":
                    nivelCurso = NivelCurso.valueOf(valor);
                    break;
                case "disciplinas":
                    // Processar as disciplinas separadas por "|"
                    String[] disciplinaInfo = valor.split("\\|");
                    for (int i = 1; i < disciplinaInfo.length; i += 2) {
                        String codigoDisciplina = disciplinaInfo[i - 1].trim();
                        String nomeDisciplina = disciplinaInfo[i].trim();
                        // Criar e adicionar uma nova disciplina à lista
                        disciplinas.add(new Disciplina(codigoDisciplina, nomeDisciplina, 0));
                    }
                    break;
                default:
                    // Se o atributo for desconhecido, ignorar
                    break;
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
