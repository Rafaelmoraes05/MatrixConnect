package SistemaNovaMatriz;

public class Equivalencia {
    private int codigoMatriz1;
    private String codigoDisciplina1;
    private int codigoMatriz2;
    private String codigoDisciplina2;
    private String nomeDisciplina2;

    
    public Equivalencia(int codigoMatriz1, String codigoDisciplina1, int codigoMatriz2, String codigoDisciplina2, String nomeDisciplina2) {
        this.codigoMatriz1 = codigoMatriz1;
        this.codigoDisciplina1 = codigoDisciplina1;
        this.codigoMatriz2 = codigoMatriz2;
        this.codigoDisciplina2 = codigoDisciplina2;
        this.nomeDisciplina2 = nomeDisciplina2;
    }
    
    public int getCodigoMatriz1() {
        return codigoMatriz1;
    }
    
    public void setCodigoMatriz1(int codigoMatriz1) {
        this.codigoMatriz1 = codigoMatriz1;
    }
    
    public String getCodigoDisciplina1() {
        return codigoDisciplina1;
    }

    public void setCodigoDisciplina1(String codigoDisciplina1) {
        this.codigoDisciplina1 = codigoDisciplina1;
    }
    
    public int getCodigoMatriz2() {
        return codigoMatriz2;
    }
    
    public void setCodigoMatriz2(int codigoMatriz2) {
        this.codigoMatriz2 = codigoMatriz2;
    }
    
    public String getCodigoDisciplina2() {
        return codigoDisciplina2;
    }
    
    public void setCodigoDisciplina2(String codigoDisciplina2) {
        this.codigoDisciplina2 = codigoDisciplina2;
    }
    public String getNomeDisciplina2() {
        return nomeDisciplina2;
    }
    
    public void setNomeDisciplina2(String nomeDisciplina2) {
        this.nomeDisciplina2 = nomeDisciplina2;
    }
}

