
package projeto;

import java.util.ArrayList;
import java.util.Calendar;

public class ExameNR extends Exame{

    public ExameNR(Calendar dataHora, int duracao, Sala sala) {
        super(dataHora, duracao, sala);
    }

    @Override
    public void inscreveAluno(ArrayList<Aluno> listAlunos) {
        
    }
    
}
