
package projeto;

public class NaoDocente extends Funcionario{
    private String cargo;
    
    public NaoDocente(String nome, String email, String cargo, int numeroMec, String categoria) {
        super(numeroMec, categoria, nome, email);
        this.cargo = cargo;
    }
}
