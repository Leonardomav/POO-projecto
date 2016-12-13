package projeto;

public class Aluno extends Pessoa{
    private int numeroEst, anoMatricula;
    private Curso curso;
    private String regime;

    public Aluno(int numeroEst, int anoMatricula, Curso curso, String regime) {
        this.numeroEst = numeroEst;
        this.anoMatricula = anoMatricula;
        this.curso = curso;
        this.regime = regime;
    }

    public int getNumeroEst() {
        return numeroEst;
    }
    
    
    public void imprimeExames(){
        
    }
    
}
