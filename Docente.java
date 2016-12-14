package projeto;

import java.io.Serializable;

public class Docente extends Funcionario implements Serializable{
    private  String areaInv;

    public Docente(String nome, String email, String areaInv, int numeroMec, String categoria) {
        super(numeroMec, categoria, nome, email);
        this.areaInv = areaInv;
    }
    
    
    
    
    
    
}
