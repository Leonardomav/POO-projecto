package projeto;

import java.io.Serializable;

public class Aluno extends Pessoa implements Serializable{
    private final int anoMatricula;
    private final long numeroEst;
    private final Curso curso;
    private final String regime;

    public Aluno(String nome, String email, long numeroEst, int anoMatricula, Curso curso, String regime) {
        super(nome, email);
        this.numeroEst = numeroEst;
        this.anoMatricula = anoMatricula;
        this.curso = curso;
        this.regime = regime;
    }

    @Override
    public String toString() {
        return "Aluno{" + "anoMatricula=" + anoMatricula + ", numeroEst=" + numeroEst + ", curso=" + curso + ", regime=" + regime + '}';
    }

    public long getNumeroEst() {
        return numeroEst;
    }
    
    public void imprimeExames(){
        
    }
    
}
