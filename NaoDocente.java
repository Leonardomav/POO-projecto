package projeto;

import java.io.Serializable;

public class NaoDocente extends Funcionario implements Serializable{
    private String cargo;
    
    public NaoDocente(String nome, String email, String cargo, int numeroMec, String categoria) {
        super(numeroMec, categoria, nome, email);
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "NaoDocente{" + "cargo=" + cargo + '}';
    }
}
