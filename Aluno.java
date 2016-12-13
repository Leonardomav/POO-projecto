package projeto;

public class Aluno extends Pessoa{
    private int numeroEst, anoMatricula;
    private Curso curso;
    private String regime;

    public Aluno(String nome, String email, int numeroEst, int anoMatricula, Curso curso, String regime) {
        super(nome, email);
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
