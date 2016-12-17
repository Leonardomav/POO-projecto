
package projeto;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Funcionario extends Pessoa implements Serializable{
    private int numeroMec;
    private String categoria;
    private Boolean tipo;
    private ArrayList<Exame> vigilancias = new ArrayList<Exame>();

    public Funcionario(int numeroMec, String categoria, String nome, String email, Boolean tipo) {
        super(nome, email);
        this.numeroMec = numeroMec;
        this.categoria = categoria;
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public void imprimeExames(ArrayList<Curso> listaCursos){
        
    }

    public int getNumeroMec() {
        return numeroMec;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public ArrayList<Exame> getVigilancias() {
        return vigilancias;
    }
    
    public void addVigilancias(Exame novoExame) {
        vigilancias.add(novoExame);
    }
    
    
    
    
}
