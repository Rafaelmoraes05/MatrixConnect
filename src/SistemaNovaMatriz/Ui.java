package SistemaNovaMatriz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ui {
    public static void main(String[] args) {
        System.out.println("\n\nBem-vindo ao sistema de equivalência!!!");
        System.out.println("\n\nLeitura do histórico acadêmico\n");
        List<Disciplina> disciplinas = HistoricoAcademico.retornarListaDeDisciplinasDoHistorico();
        System.out.println("\n\nDisciplinas Aprovadas:\n");
        for(Disciplina d : disciplinas){
            System.out.println(d.getCodigo()+" "+d.getNome());
        }
        List<Equivalencia> equivalencias = TratadorEquivalencia.lerEquivalencias();

        List<Disciplina> disciplinasAproveitadas = new ArrayList<Disciplina>();

        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina d = disciplinas.get(i);
            for (int j = 0; j < equivalencias.size(); j++) {
                Equivalencia e = equivalencias.get(j);
        
                if (d.getCodigo().equalsIgnoreCase(e.getCodigoDisciplina1())) {
                    // Verifica se há outras equivalências com a mesma disciplina a ser dispensada
                    boolean todasDisciplinasNecessariasAprovadas = true;
        
                    for (int k = 0; k < equivalencias.size(); k++) {
                        Equivalencia outraEquivalencia = equivalencias.get(k);
                        if (e.getCodigoDisciplina2().equalsIgnoreCase(outraEquivalencia.getCodigoDisciplina2())) {
                            boolean disciplinaNecessariaAprovada = false;
        
                            // Verifica se a disciplina necessária está na lista de disciplinas aprovadas
                            for (Disciplina discAprovada : disciplinas) {
                                if (discAprovada.getCodigo().equalsIgnoreCase(outraEquivalencia.getCodigoDisciplina1())) {
                                    disciplinaNecessariaAprovada = true;
                                    break;
                                }
                            }
        
                            if (!disciplinaNecessariaAprovada) {
                                todasDisciplinasNecessariasAprovadas = false;
                                break;
                            }
                        }
                    }
        
                    if (todasDisciplinasNecessariasAprovadas) {
                        disciplinasAproveitadas.add(d);
                        equivalencias.remove(j);
                        j--; // Ajusta o índice após a remoção
                    }
                }
            }
        }
        
        
        

        System.out.println("\n\nDisciplinas Aproveitadas na nova matriz:\n");
        for(Disciplina d: disciplinasAproveitadas){
            System.out.println(d.getCodigo()+" "+d.getNome());
        }

        Set<String> equivalenciasSemDuplicatas = new HashSet<>();
        for(Equivalencia e: equivalencias){
            equivalenciasSemDuplicatas.add(e.getCodigoDisciplina2()+" "+e.getNomeDisciplina2());
        }

        System.out.println("\n\nDisciplinas que precisam ser cursadas na nova matriz:\n");
        for(String e: equivalenciasSemDuplicatas){
            System.out.println(e);
        }

        System.out.println("\nFim");
    }
}
