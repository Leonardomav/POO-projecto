package projeto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import static projeto.Projeto.retornaFloat;


public abstract class Exame implements Serializable{
    private final Calendar dataHora;
    private final int duracao; //minutos
    private Sala sala;
    private ArrayList<Docente> listVigilantes;
    private ArrayList<NaoDocente> listNaoDocente;
    private ArrayList<Aluno> listAlunos;
    private ArrayList<Float> listNotas;
    private final int tipo;

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
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return "Exame na data " + formatter.format(getDataHora().getTime()) + " com duracao de " + duracao + "min, na sala=" + sala + ", tipo=" + tipo;
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
    
     public void addListDocente(Docente novoDocente){
        listVigilantes.add(novoDocente);
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
        int i, sizeAlun;
        
        sizeAlun = listAlunos.size();
        if(sizeAlun == 0){
            System.out.println("Não existem alunos inscritos neste exame.");
            return;
        }
        System.out.println("Insira as notas dos alunos:");
        for(i=0; i<sizeAlun; i++){
            System.out.print("\tAluno " + i + ": " + listAlunos.get(i) + "\n\tNota: ");
            listNotas.add(retornaFloat());
        }
    }
    
    void imprimeNotas() {
        System.out.println("TESTE");
        System.out.println(listNotas);
    }
  
    public abstract Aluno inscreveAluno(ArrayList<Aluno> listAlunos, Disciplina auxDisciplina);

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    void imprimeFuncionarios() {
        System.out.println("Docentes:");
        System.out.println(listVigilantes);
        System.out.println("Nao Docentes");
        System.out.println(listNaoDocente);
    }

}
