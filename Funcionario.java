
package projeto;

import java.util.ArrayList;

public abstract class Funcionario extends Pessoa{
    private int numeroMec;
    private String categoria;

    public Funcionario(int numeroMec, String categoria, String nome, String email) {
        super(nome, email);
        this.numeroMec = numeroMec;
        this.categoria = categoria;
    }
    
    public void imprimeExames(ArrayList<Curso> listaCursos){
        
    }

    public int getNumeroMec() {
        return numeroMec;
    }
    
    
    
}
