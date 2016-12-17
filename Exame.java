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
    private ArrayList<NaoDocente> listNaoDocente;
    private ArrayList<Aluno> listAlunos;
    private ArrayList<Float> listNotas;
    private int tipo;

    public Exame(Calendar dataHora, int duracao, ArrayList<Docente> listVigilantes, int tipo) {
        this.dataHora = dataHora;
        this.duracao = duracao;
        this.listVigilantes = listVigilantes;
        this.tipo = tipo;
        listNaoDocente = new ArrayList<NaoDocente>();
        listAlunos = new ArrayList<Aluno>();
        listNotas = new ArrayList<Float>();
    }
    
    @Override
    public String toString() {
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "Exame{" + "dataHora=" + formatter.format(getDataHora().getTime()) + ", duracao=" + duracao + ", sala=" + sala + ", listVigilantes=" + listVigilantes + ", listFuncionarios=" + listNaoDocente + ", listAlunos=" + listAlunos + ", listNotas=" + listNotas + ", tipo=" + tipo + '}';
    }
    
    public void addListAlunos(Aluno novoAluno){
        listAlunos.add(novoAluno);
    }
    
    public void addListNotas(Float novoFloat){
        listNotas.add(novoFloat);
    }

    public void addListNaoDocente(NaoDocente novoNaoDocente){
        listNaoDocente.add(novoNaoDocente);
    }
    
    public Calendar getDataHora() {
        return dataHora;
    }

    public int getDuracao() {
        return duracao;
    }

    public Sala getSala() {
        return sala;
    }

    public ArrayList<Docente> getListVigilantes() {
        return listVigilantes;
    }

    public ArrayList<NaoDocente> getListFuncionarios() {
        return listNaoDocente;
    }

    public ArrayList<Aluno> getListAlunos() {
        return listAlunos;
    }

    public ArrayList<Float> getListNotas() {
        return listNotas;
    }

    public int getTipo() {
        return tipo;
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
    
    public abstract Aluno inscreveAluno(ArrayList<Aluno> listAlunos, Disciplina auxDisciplina);
    
}
