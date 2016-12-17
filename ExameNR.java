
package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class ExameNR extends Exame implements Serializable{

    public ExameNR(Calendar dataHora, int duracao, ArrayList<Docente> listVigilantes, int tipo) {
        super(dataHora, duracao,listVigilantes, tipo); //tipo=0 Normal, Tipo=1 Recurso
    }

    @Override
    public void inscreveAluno(ArrayList<Aluno> listAlunos) {
        
    }
    
}
