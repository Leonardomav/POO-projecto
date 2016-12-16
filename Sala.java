
package projeto;

import java.util.ArrayList;

public class Sala {
   private String departamento;
   private int numero;
   private ArrayList<Exame> exames = new ArrayList<Exame>();

    public Sala(String departamento, int numero) {
        this.departamento = departamento;
        this.numero = numero;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getNumero() {
        return numero;
    }

    public ArrayList<Exame> getExames() {
        return exames;
    }

}
