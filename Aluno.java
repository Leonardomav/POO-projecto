package projeto;

import java.io.Serializable;
import java.util.ArrayList;

public class Aluno extends Pessoa implements Serializable{
    private final int anoMatricula;
    private final long numeroEst;
    private final Curso curso;
    private final String regime;
    private final ArrayList<Exame> inscricoes;

    public Aluno(String nome, String email, long numeroEst, int anoMatricula, Curso curso, String regime) {
        super(nome, email);
        this.numeroEst = numeroEst;
        this.anoMatricula = anoMatricula;
        this.curso = curso;
        this.regime = regime;
        this.inscricoes = new ArrayList<Exame>();
    }

    @Override
    public String toString() {
        return getNome() + " - " + numeroEst;
    }
    
    public void addListInscricoes(Exame novoExame){
        inscricoes.add(novoExame);
    }

    public int getAnoMatricula() {
        return anoMatricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public String getRegime() {
        return regime;
    }

    public ArrayList<Exame> getInscricoes() {
        return inscricoes;
    }

    public long getNumeroEst() {
        return numeroEst;
    }
    
    public void imprimeExames(){
        
    }
    
}
