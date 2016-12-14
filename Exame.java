package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public abstract class Exame implements Serializable{
    private final Date dataHora;
    private final int duracao; //minutos
    private final Sala sala;
    private ArrayList<Docente> listVigilantes;
    private ArrayList<NaoDocente> listFuncionarios;
    private ArrayList<Integer> listAlunos;
    private ArrayList<Float> listNotas;

    public Exame(Date dataHora, int duracao, Sala sala) {
        this.dataHora = dataHora;
        this.duracao = duracao;
        this.sala = sala;
    }
    
    
    public void defineNotas(){
        
    }
    
    public void imprimeAlunosInscritos(){
        
    }
    
    public void imprimeFuncConvocados(){
        
    }
    
    public void imprimeNotas(ArrayList<Sala> listSala){
        
    }
    
    public void escolheDecentes(ArrayList<Docente> listDocente){
        
    }
    
    public void escolheNaoDocente(ArrayList<NaoDocente> listNaoDocente){
        
    }
    
    public abstract void inscreveAluno(ArrayList<Aluno> listAlunos);
    
}
