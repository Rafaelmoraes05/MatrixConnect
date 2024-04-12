package SistemaNovaMatriz;

import java.util.List;

public class Matriz {
    private int ano;
    private int codigo;
    private String nomeCurso;
    private List<Disciplina> disciplinas;
    private NivelCurso nivelCurso;

    public Matriz(int ano, int codigo, String nomeCurso, List<Disciplina> disciplinas, NivelCurso nivelCurso) {
        this.ano = ano;
        this.codigo = codigo;
        this.nomeCurso = nomeCurso;
        this.disciplinas = disciplinas;
        this.nivelCurso = nivelCurso;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public NivelCurso getNivelCurso() {
        return nivelCurso;
    }

    public void setNivelCurso(NivelCurso nivelCurso) {
        this.nivelCurso = nivelCurso;
    }
}

enum NivelCurso{
    GRADUACAO,
    POS_GRADUACAO,
    TECNICO
}


