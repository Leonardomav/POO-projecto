package projeto;

public class Docente extends Funcionario {
    private  String areaInv;

    public Docente(String nome, String email, String areaInv, int numeroMec, String categoria) {
        super(numeroMec, categoria, nome, email);
        this.areaInv = areaInv;
    }
    
    
    
    
    
    
}
