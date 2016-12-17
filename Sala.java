
package projeto;

import java.util.ArrayList;

public class Sala {
   private final String departamento;
   private final int numero;
   private ArrayList<Exame> exames;

    public Sala(String departamento, int numero) {
        this.departamento = departamento;
        this.numero = numero;
        this.exames = new ArrayList<Exame>();
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
