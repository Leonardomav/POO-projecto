
package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class ExameE extends Exame implements Serializable{

    public ExameE(Calendar dataHora, int duracao) {
        super(dataHora, duracao, 2);
    }

    @Override
    public void inscreveAluno(ArrayList<Aluno> listAlunos) {
        
    }
    
}
