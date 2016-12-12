package projeto;

import java.util.ArrayList;
import java.util.Date;

public abstract class Exame {
    private Disciplina disciplina;
    private Date dataHora;
    private int duracao; //minutos
    private Sala sala;
    private ArrayList<Docente> listVigilantes;
    private ArrayList<NaoDocente> listFuncionarios;
    private ArrayList<Aluno> listAlunos;
    private ArrayList<Float> listNotas;
    
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
