
package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ExameE extends Exame implements Serializable{

    public ExameE(Date dataHora, int duracao, Sala sala) {
        super(dataHora, duracao, sala);
    }

    @Override
    public void inscreveAluno(ArrayList<Aluno> listAlunos) {
        
    }
    
}
