package projeto;

import java.io.Serializable;

public class Aluno extends Pessoa implements Serializable{
    private int anoMatricula;
    private long numeroEst;
    private Curso curso;
    private String regime;

    public Aluno(String nome, String email, long numeroEst, int anoMatricula, Curso curso, String regime) {
        super(nome, email);
        this.numeroEst = numeroEst;
        this.anoMatricula = anoMatricula;
        this.curso = curso;
        this.regime = regime;
    }

    public long getNumeroEst() {
        return numeroEst;
    }
    
    public void imprimeExames(){
        
    }
    
}
