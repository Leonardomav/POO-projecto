
package projeto;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.GregorianCalendar;
import static projeto.Projeto.retornaInteiro;


public class Disciplina implements Serializable{
    private final String nome;
    private final int docenteResp;
    private ArrayList<Long> listAlunos = new ArrayList<Long>();
    private ArrayList<Integer> listDocentes = new ArrayList<Integer>();
    private ArrayList<Exame> listExames = new ArrayList<Exame>();

    public Disciplina(String nome, int docenteResp) {
       this.nome=nome;
       this.docenteResp=docenteResp;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "nome=" + nome + ", docenteResp=" + docenteResp + ", listAlunos=" + listAlunos + ", listDocentes=" + listDocentes + ", listExames=" + listExames + '}';
    }

    public String getNome() {
        return nome;
    }
    
    public void addDocentes(ArrayList<Docente> listDocentesGlobal){
        int size_global=listDocentesGlobal.size();
        int index, flag=1, opcao;
        
        
        System.out.println("Qual docente quer adicionar?");
        while(flag==1){
            index=0;
            for (int j = 1; j <= size_global; j++){
                if((!(listDocentes.contains(listDocentesGlobal.get(j-1).getNumeroMec())))&&(listDocentesGlobal.get(j-1).getNumeroMec()!=docenteResp)){
                    index++;
                    System.out.println(index + " - " + listDocentesGlobal.get(index-1).getNome());
                }
            }
            if(index!=0){
                System.out.print("-> ");
                while(true){
                    opcao=retornaInteiro();
                    if(opcao>0 && opcao<=index) break;
                    System.out.println("Opção Inválida");
                }
                index=0;
                for (int j = 1; j <= size_global; j++){
                    if(!(listDocentes.contains(listDocentesGlobal.get(j-1).getNumeroMec()))){
                        index++;
                        if(index==opcao){
                            listDocentes.add(listDocentesGlobal.get(j-1).getNumeroMec());
                        }
                    }
                }
                System.out.print("Deseja adicionar mais algum docente a esta disciplina?\n1 - Sim\n2 - Não\n->");
                while(true){
                    opcao=retornaInteiro();
                    if(opcao==1 || opcao==2) break;
                    System.out.println("Opção Inválida");
                }
                if(opcao==2) flag=0;
            }
            else{
                System.out.println("Não existem alunos não inscritos na cadeira!");
                flag=0;
            }
        }
    }
    
    public void addAlunos(ArrayList<Aluno> listAlunosGlobal){
        int size_global=listAlunosGlobal.size();
        int index, flag=1, opcao;
        
        
        System.out.println("Qual aluno quer adicionar?");
        while(flag==1){
            index=0;
            for (int j = 1; j <= size_global; j++){
                if(!(listAlunos.contains(listAlunosGlobal.get(j-1).getNumeroEst()))){
                    index++;
                    System.out.println(index + " - " + listAlunosGlobal.get(index-1).getNome());
                }
            }
            if(index!=0){
                System.out.print("-> ");
                while(true){
                    opcao=retornaInteiro();
                    if(opcao>0 && opcao<=index) break;
                    System.out.println("Opção Inválida");
                }
                index=0;
                for (int j = 1; j <= size_global; j++){
                    if(!(listAlunos.contains(listAlunosGlobal.get(j-1).getNumeroEst()))){
                        index++;
                        if(index==opcao){
                            listAlunos.add(listAlunosGlobal.get(j-1).getNumeroEst());
                        }
                    }
                }
                System.out.print("Deseja adicionar mais algum aluno a esta disciplina?\n1 - Sim\n2 - Não\n->");
                while(true){
                    opcao=retornaInteiro();
                    if(opcao==1 || opcao==2) break;
                    System.out.println("Opção Inválida");
                }
                if(opcao==2) flag=0;
            }
            else{
                System.out.println("Não existem alunos não inscritos na cadeira!");
                flag=0;
            }
        }
    }
    
    public void criaExame( ArrayList<Sala> listSalas){
        int ano, mes, dia, hora, min, flag, duracao, size_salas, opcao=0, aux_dur;
        Sala sala_aux;
        Exame exames_aux;
        Calendar data_aux, dataplus, dataplus_aux;
        Calendar data = new GregorianCalendar();

        
        size_salas = listSalas.size();
        
        do{
            System.out.print("Ano:");
            ano=retornaInteiro();
            System.out.print("Mes:");
            mes=retornaInteiro();
            System.out.println("Dia:");
            dia=retornaInteiro();
            System.out.println("Hora");  
            hora=retornaInteiro();
            System.out.println("Min");
            min=retornaInteiro();
            flag=dataValida(dia, mes, ano, hora,  min);
        }while(flag==0);
        data.clear();
        data.set(ano,mes-1,dia,hora,min);
        
        flag=0;
        do{
            System.out.print("Duração em minutos:");
            duracao=retornaInteiro();
            if(duracao>0) flag=1;
        }while(flag==0);
        
        
    
        do{
            System.out.println("Exame em que sala: ");
            for(int i=1; i<=size_salas; i++){
                System.out.println(i + " - " + listSalas.get(i-1).getDepartamento() + " - " + listSalas.get(i-1).getNumero());
            }

            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<size_salas+1) flag=0;
            System.out.println("Opção Inválida");
        
            dataplus=data;
            dataplus.add(Calendar.MINUTE, duracao);
            for(int i=0;i<listSalas.get(opcao-1).getExames().size(); i++){
                exames_aux=listSalas.get(opcao-1).getExames().get(i);
                data_aux=exames_aux.getDataHora();
                aux_dur=exames_aux.getDuracao();
                dataplus_aux=data_aux;
                dataplus_aux.add(Calendar.MINUTE, aux_dur);
                flag=checkSalas(data, dataplus, data_aux, dataplus_aux);
            }
        }while(flag==0);
        
        System.out.println("Deseja Criar um Exame :\n1 - Normal\n2 - Recurso\n3 - Especial");
        //........
        
    }

    public void addListAlunos(long Aluno) {
        this.listAlunos.add(Aluno);
    }

    public void addListDocentes(int Docente) {
        this.listDocentes.add(Docente);
    }
    
    //*****************************************mudar esta funçao*************************************************
    private static int dataValida(int dd, int mm, int yy, int hora, int min) {
        int bissextile;
        if (yy%4==0)
            bissextile=1;
        else
            bissextile=0;
        if (yy==-1) {
            System.out.println("Data Invalida.\n");
            return 0;
        }
 
        if(dd > 31 || dd < 1 || mm > 12 || mm < 1) {
            System.out.println("Data Invalida.\n");
            return 0;
        }
        else if(mm == 2 && dd < 30 && bissextile==1 && (hora >= 0 && hora <= 23) && (min >= 0 && min <= 59) || mm == 2 && dd < 29 && bissextile==1) {
            return 1;
        } else if((mm == 4 || mm == 6 || mm == 9 || mm == 11) && dd < 31 && (hora >= 0 && hora <= 23) && (min >= 0 && min <= 59)) {
            return 1;
        } else if(dd < 31 && mm != 2 && (hora >= 0 && hora <= 23) && (min >= 0 && min <= 59)) {
            return 1;
        } else {
            System.out.println("Data Invalida.\n");
            return 0;
        }
    }
    
    private static int checkSalas(Calendar data, Calendar dataplus, Calendar data_aux, Calendar dataplus_aux){
        int compare;
        compare = data.compareTo(data_aux);
        if(compare==0) return 0;
        else if(compare <0){ //data antes de data_aux
            compare=dataplus.compareTo(data_aux);
            if(compare==0) return 1;
            else if(compare <0) return 1;
            else return 0;
        }
        else{ //data depois de data_aux
            compare=data.compareTo(dataplus_aux);
            if(compare==0) return 1;
            else if(compare <0) return 0;
            else return 1;
        }
    }

}
