
package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class ExameNR extends Exame implements Serializable{

    public ExameNR(Calendar dataHora, int duracao, Sala sala, int tipo) {
        super(dataHora, duracao, sala, tipo); //tipo=0 Normal, Tipo=1 Recurso
    }

    @Override
    public void inscreveAluno(ArrayList<Aluno> listAlunos) {
        
    }
    
}
