package projeto;

import java.io.Serializable;
import java.util.ArrayList;

public class Aluno extends Pessoa implements Serializable{
    private final int anoMatricula;
    private final long numeroEst;
    private final Curso curso;
    private final String regime;
    private final ArrayList<Exame> inscricoes;

    /**
     * 
     * @param nome nome do aluno
     * @param email email do aluno
     * @param numeroEst numero de estudante
     * @param anoMatricula ano da matricula
     * @param curso curso do aluno
     * @param regime regime do aluno
     */
    public Aluno(String nome, String email, long numeroEst, int anoMatricula, Curso curso, String regime) {
        super(nome, email);
        this.numeroEst = numeroEst;
        this.anoMatricula = anoMatricula;
        this.curso = curso;
        this.regime = regime;
        this.inscricoes = new ArrayList<Exame>();
    }
    
    /**
     * 
     * @return string com numero de estudante do aluno
     */
    @Override
    public String toString() {
        return getNome() + " - " + numeroEst;
    }
    
    /**
     * Adiciona um exame a lista de inscriçoes.
     * 
     * @param novoExame exame a ser adicionado
     */
    public void addListInscricoes(Exame novoExame){
        inscricoes.add(novoExame);
    }
    
    /**
     * 
     * @return ano da matricula
     */
    public int getAnoMatricula() {
        return anoMatricula;
    }
    /**
     * 
     * @return curso do aluno
     */
    public Curso getCurso() {
        return curso;
    }
    /**
     * 
     * @return regime do aluno
     */
    public String getRegime() {
        return regime;
    }
    /**
     * 
     * @return lista de exames em que um aluno esta inscrito
     */
    public ArrayList<Exame> getInscricoes() {
        return inscricoes;
    }
    /**
     * 
     * @return numero de aluno de um estudante
     */
    public long getNumeroEst() {
        return numeroEst;
    }
}
