
package projeto;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.GregorianCalendar;
import static projeto.Projeto.retornaInteiro;


public class Disciplina implements Serializable{
    private final String nome;
    private final Docente docenteResp;
    private ArrayList<Aluno> listAlunos = new ArrayList<Aluno>();
    private ArrayList<Docente> listDocentes = new ArrayList<Docente>();
    private ArrayList<Exame> listExames = new ArrayList<Exame>();

    public Disciplina(String nome, Docente docenteResp) {
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

    public Docente getDocenteResp() {
        return docenteResp;
    }

    public ArrayList<Aluno> getListAlunos() {
            return listAlunos;
    }

    public ArrayList<Docente> getListDocentes() {
        return listDocentes;
    }

    public ArrayList<Exame> getListExames() {
        return listExames;
    }
    
    public void addDocentes(ArrayList<Funcionario> listFuncionariosGlobal){
        int size_global=listFuncionariosGlobal.size();
        int index, flag=1, opcao, i;
        Docente auxDocente;
        
        
        System.out.println("Qual docente quer adicionar?");
        while(flag==1){
            index=0;

            for (i=0; i<size_global; i++){
                if(listFuncionariosGlobal.get(i).getTipo()){
                    auxDocente=(Docente) listFuncionariosGlobal.get(i);
                    if((!(listDocentes.contains(auxDocente))) && (auxDocente!=docenteResp)){
                        index++;
                        System.out.println(index + " - " + auxDocente.getNome());
                    }
                }
            }
            if(index!=0){
                System.out.print("-> ");
                while(true){
                    opcao=retornaInteiro();
                    if(opcao>0 && opcao<=index) break;
                    System.out.println("Opção inválida");
                }
                index=0;

                for (i=0; i < size_global; i++){
                    if(listFuncionariosGlobal.get(i).getTipo()){
                        auxDocente=(Docente) listFuncionariosGlobal.get(i);
                        if((!(listDocentes.contains(auxDocente))) && (auxDocente!=docenteResp)){
                            index++;
                            if(index==opcao){
                                listDocentes.add(auxDocente);
                                break;
                            }
                        }
                    }
                }
                System.out.print("Deseja adicionar mais algum docente a esta disciplina?\n1 - Sim\n2 - Não\n-> ");
                while(true){
                    opcao=retornaInteiro();
                    if(opcao==1 || opcao==2) break;
                    System.out.println("Opção inválida");
                }
                if(opcao==2) flag=0;
            }
            else{
                System.out.println("Não existem docentes não inscritos na cadeira!");
                flag=0;
            }
        }
    }
    
    public void addAlunos(ArrayList<Aluno> listAlunosGlobal){
        int i, size_global=listAlunosGlobal.size();
        int index, flag=1, opcao;
        Aluno auxAluno;
        
        
        System.out.println("Qual aluno quer adicionar?");
        while(flag==1){
            index=0;
            for (i=0; i<size_global; i++){
                auxAluno=listAlunosGlobal.get(i);
                if(!(listAlunos.contains(auxAluno))){
                    index++;
                    System.out.println(index + " - " + auxAluno.getNome());
                }
            }
            if(index!=0){
                System.out.print("-> ");
                while(true){
                    opcao=retornaInteiro();
                    if(opcao>0 && opcao<=index) break;
                    System.out.println("Opção inválida");
                }
                index=0;
                for (i = 0; i < size_global; i++){
                    auxAluno=listAlunosGlobal.get(i);
                    if(!(listAlunos.contains(auxAluno))){
                        index++;
                        if(index==opcao){
                            listAlunos.add(auxAluno);
                            break;
                        }
                    }
                }
                System.out.print("Deseja adicionar mais algum aluno a esta disciplina?\n1 - Sim\n2 - Não\n-> ");
                while(true){
                    opcao=retornaInteiro();
                    if(opcao==1 || opcao==2) break;
                    System.out.println("Opção inválida");
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
        int ano, mes, dia, hora, min, flag, duracao, size_salas, opcao=0, aux_dur, free, aux;
        Sala sala_aux = null;
        Exame exames_aux;
        Calendar data_aux, dataplus, dataplus_aux;
        Calendar data = new GregorianCalendar();

        size_salas = listSalas.size();
        
        do{
            System.out.print("Ano: ");
            ano=retornaInteiro();
            System.out.print("Mes: ");
            mes=retornaInteiro();
            System.out.print("Dia: ");
            dia=retornaInteiro();
            System.out.print("Hora: ");  
            hora=retornaInteiro();
            System.out.print("Min: ");
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
        
        dataplus=data;
        dataplus.add(Calendar.MINUTE, duracao);
    
        do{
            aux=0;
            System.out.println("Exame em que sala: ");
            for(int i=0; i<size_salas; i++){
                free=0;
                for(int j=0;j<listSalas.get(i).getExames().size(); i++){
                    exames_aux=listSalas.get(i).getExames().get(j);
                    data_aux=exames_aux.getDataHora();
                    aux_dur=exames_aux.getDuracao();
                    dataplus_aux=data_aux;
                    dataplus_aux.add(Calendar.MINUTE, aux_dur);
                    free=checkSala(data, dataplus, data_aux, dataplus_aux);
                }
                if(free==0){
                    aux++;
                    System.out.println(aux + " - " + listSalas.get(i).getDepartamento() + " - " + listSalas.get(i).getNumero());
                }   
            }

            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<size_salas+1) flag=1;
            else System.out.println("Opção Inválida");
             
        }while(flag==0);
        
        for(int i=0; i<size_salas; i++){
            free=0;
            for(int j=0;j<listSalas.get(i).getExames().size(); i++){
                exames_aux=listSalas.get(i).getExames().get(j);
                data_aux=exames_aux.getDataHora();
                aux_dur=exames_aux.getDuracao();
                dataplus_aux=data_aux;
                dataplus_aux.add(Calendar.MINUTE, aux_dur);
                free=checkSala(data, dataplus, data_aux, dataplus_aux);
            }
            if(free==0){
                aux++;
            }   
            if(aux==opcao)
                sala_aux=listSalas.get(i);
        }
        
        
        flag=1;
        do{
            System.out.println("Deseja Criar um Exame :\n1 - Normal\n2 - Recurso\n3 - Especial");
            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<4) flag=1;
            else System.out.println("Opção Inválida");
        }while(flag==0);
        
        switch(opcao){
            case 1:
                listExames.add(new ExameNR(data, duracao, sala_aux, 0));
                break;
            case 2:   
                listExames.add(new ExameNR(data, duracao, sala_aux, 1));
                break;
            case 3:
                listExames.add(new ExameE(data, duracao, sala_aux));
                break;
        }
    }

    public void addListAlunos(Aluno aluno) {
        this.listAlunos.add(aluno);
    }

    public void addListDocentes(Docente docente) {
        this.listDocentes.add(docente);
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
    
    private static int checkSala(Calendar data, Calendar dataplus, Calendar data_aux, Calendar dataplus_aux){
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

    void imprimeExamesDisciplina() {
        int i, size;
        size = listExames.size();
        for(i=0; i<size; i++){
            System.out.println("\t\ti - " + listExames.get(i).toString());
        }
    }

}
