package projeto;

import java.io.Serializable;

public class Docente extends Funcionario implements Serializable{
    private  String areaInv;

    public Docente(String nome, String email, String areaInv, int numeroMec, String categoria) {
        super(numeroMec, categoria, nome, email, true);
        this.areaInv = areaInv;
    }

    @Override
    public String toString() {
        return "Docente de categoria " + getCategoria() + " - Nome: " + getNome() + ", e-mail: " + getEmail() + ", numero: " + getNumeroMec() + ", area de investigacao: " + areaInv;
    }
}
