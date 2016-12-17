package projeto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public abstract class Exame implements Serializable{
    private final Calendar dataHora;

    private final int duracao; //minutos
    private Sala sala;
    private ArrayList<Docente> listVigilantes;
    private ArrayList<NaoDocente> listFuncionarios;
    private ArrayList<Long> listAlunos;
    private ArrayList<Float> listNotas;
    private int tipo;

    public Exame(Calendar dataHora, int duracao, int tipo) {
        this.dataHora = dataHora;
        this.duracao = duracao;
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "Exame{" + "dataHora=" + formatter.format(getDataHora().getTime()) + ", duracao=" + duracao + ", sala=" + sala + ", listVigilantes=" + listVigilantes + ", listFuncionarios=" + listFuncionarios + ", listAlunos=" + listAlunos + ", listNotas=" + listNotas + ", tipo=" + tipo + '}';
    }

    public Calendar getDataHora() {
        return dataHora;
    }

    public int getDuracao() {
        return duracao;
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
