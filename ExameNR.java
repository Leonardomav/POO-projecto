
package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ExameNR extends Exame implements Serializable{

    public ExameNR(Date dataHora, int duracao, Sala sala) {
        super(dataHora, duracao, sala);
    }

    @Override
    public void inscreveAluno(ArrayList<Aluno> listAlunos) {
        
    }
    
}
