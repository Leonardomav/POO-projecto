
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
        //return "Disciplina{" + "nome=" + nome + ", docenteResp=" + docenteResp + ", listAlunos=" + listAlunos + ", listDocentes=" + listDocentes + ", listExames=" + listExames + '}';
        return "Disciplina{" + "nome=" + nome + ", docenteResp=" + docenteResp + '}';
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
        int sizeGlobal=listFuncionariosGlobal.size();
        int index, flag=1, opcao, i;
        Docente auxDocente;
        
        
        System.out.println("Qual docente quer adicionar?");
        while(flag==1){
            index=0;
            for (i=0; i<sizeGlobal; i++){
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

                for (i=0; i < sizeGlobal; i++){
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
    
    public void criaExame(){
        int ano, mes, dia, hora, min, flag, duracao, opcao=0, auxDur, aux, index, quit, first=0;
        ArrayList<Exame> exameAux;
        ArrayList<Docente> docentesVigilantes = new ArrayList<Docente>();
        Calendar dataAux, dataplus, dataplusAux;
        Calendar data = new GregorianCalendar();

        
        do{
            System.out.println("------------");
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
            flag=verifica_data(dia, mes, ano, hora,  min);
        }while(flag==0);
        data.clear();
        data.set(ano,mes-1,dia,hora,min);   
        
        flag=0;
        do{
            System.out.print("Duração em minutos:");
            duracao=retornaInteiro();
            if(duracao>0) flag=1;
        }while(flag==0);
        
        dataplus=(Calendar)data.clone();
        dataplus.add(Calendar.MINUTE, duracao);
        
        do{
            quit=0;
            do{
                flag=0;
                index = 0;
                System.out.println("Que docente quer adicionar à vigilancia do exame: ");
                for(int i =0; i<listDocentes.size(); i++){
                    if(!(docentesVigilantes.contains(docenteResp))){
                        index++;
                        System.out.println(index + " - " + docenteResp.getNome());
                    }
                    if((listDocentes.get(i).getTipo()==true) && !(docentesVigilantes.contains(listDocentes.get(i)))){
                        exameAux=listDocentes.get(i).getVigilancias();
                        aux=0;
                        for(int j=0; j<exameAux.size(); j++){
                            dataAux=exameAux.get(i).getDataHora();
                            auxDur=exameAux.get(i).getDuracao();
                            dataplusAux=(Calendar) dataAux.clone();
                            dataplusAux.add(Calendar.MINUTE, auxDur);
                            aux+=checkHora(data, dataplus, dataAux, dataplusAux);
                        }
                        if(aux==exameAux.size()){
                            index++;
                            System.out.println(index + " - " + listDocentes.get(i).getNome());
                        }
                    }
                }
                if(index==0){
                    System.out.println("Não existem docentes disponiveis");
                    quit=1;
                    break;
                }

                System.out.print("-> ");
                opcao=retornaInteiro();
                if(opcao>0 && opcao<=index) flag=1;
                else System.out.println("Opção Inválida");
            }while(flag==0);

            if(quit==0){
                index=0;
                for(int i =0; i<listDocentes.size(); i++){
                    if(!(docentesVigilantes.contains(docenteResp))){
                        index++;
                        if(index==opcao){
                            docentesVigilantes.add(docenteResp);
                            first=1;
                            System.out.println("Docente Adicionado!");
                            break;
                        }
                    }  
                    if((listDocentes.get(i).getTipo()==true)&&!(docentesVigilantes.contains(listDocentes.get(i)))){
                        exameAux=listDocentes.get(i).getVigilancias();
                        aux=0;
                        for(int j=0; j<exameAux.size(); j++){
                            dataAux=exameAux.get(i).getDataHora();
                            auxDur=exameAux.get(i).getDuracao();
                            dataplusAux=(Calendar)dataAux.clone();
                            dataplusAux.add(Calendar.MINUTE, auxDur);
                            aux+=checkHora(data, dataplus, dataAux, dataplusAux);
                        }
                        if(aux==exameAux.size()){
                            index++;
                        }
                        if(index==opcao){
                            docentesVigilantes.add(listDocentes.get(i));
                            first=1;
                            System.out.println("Docente Adicionado!");
                        }
                    }
                }
                while(true){
                    System.out.print("Quer adicionar mais docentes à vigilancia?\n1 - Sim\n2 - Não\n-> ");
                    opcao=retornaInteiro();
                    if(opcao==1 || opcao==2) break;
                    System.out.println("Opção Inválida");
                }
                if(opcao==2) quit=1;
            }
        }while(quit==0);

        if(first!=0){
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
                    listExames.add(new ExameNR(data, duracao, docentesVigilantes,0));
                    break;
                case 2:   
                    listExames.add(new ExameNR(data, duracao, docentesVigilantes,1));
                    break;
                case 3:
                    listExames.add(new ExameE(data, duracao, docentesVigilantes));
                    break;
            }
            for(int i=0; i<docentesVigilantes.size(); i++){
                docentesVigilantes.get(i).addVigilancias(listExames.get(listExames.size()-1));
            }
            
            System.out.println("Exame criado!");
        }
        else System.out.println("Impossível criar um exame!");
    }
    
    public void configuraSala(ArrayList<Sala> listSalas){
        int size_salas = listSalas.size();
        int aux, free, auxDur, opcao, duracao, flag, quit=0;
        Exame exameAux, exame;
        Calendar data, dataAux, dataplus, dataplusAux;
        
        while(true){
            System.out.println("Qual exame?");
            for (int i = 0; i < listExames.size(); i++)
                System.out.println(i+1 + " - " + listExames.get(i).toString());

            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<=listExames.size()) break;
            System.out.println("Opção Inválida");
        }
        exame=listExames.get(opcao-1);
        
        data=exame.getDataHora();
        duracao=exame.getDuracao();
        dataplus=(Calendar)data.clone();
        dataplus.add(Calendar.MINUTE, duracao);
        flag=0;
        do{
            aux=0;
            System.out.println("Exame em que sala: ");
            for(int i=0; i<size_salas; i++){
                free=0;
                for(int j=0;j<listSalas.get(i).getExames().size(); i++){
                    exameAux=listSalas.get(i).getExames().get(j);
                    dataAux=exameAux.getDataHora();
                    auxDur=exameAux.getDuracao();
                    dataplusAux=(Calendar)dataAux.clone();
                    dataplusAux.add(Calendar.MINUTE, auxDur);
                    free+=checkHora(data, dataplus, dataAux, dataplusAux);
                }
                if(free==listSalas.get(i).getExames().size()){
                    aux++;
                    System.out.println(aux + " - " + listSalas.get(i).getDepartamento() + " - " + listSalas.get(i).getNumero());
                }   
            }
            if(aux==0){
                System.out.println("Não existem salas diponiveis. Impossivel realizar operação!");
                quit=1;
                break;
            }
            else{
                System.out.print("-> ");
                opcao=retornaInteiro();
                if(opcao>0 && opcao<size_salas+1) flag=1;
                else System.out.println("Opção Inválida");
            }
        }while(flag==0);

        if(quit==0){
            aux=0;
            int i;
            for(i=0; i<size_salas; i++){
                free=0;
                for(int j=0;j<listSalas.get(i).getExames().size(); i++){
                        exameAux=listSalas.get(i).getExames().get(j);
                        dataAux=exameAux.getDataHora();
                        auxDur=exameAux.getDuracao();
                        dataplusAux=(Calendar)dataAux.clone();
                        dataplusAux.add(Calendar.MINUTE, auxDur);
                        free+=checkHora(data, dataplus, dataAux, dataplusAux);
                }
                if(free==listSalas.get(i).getExames().size())
                    aux++;   
                if(aux==opcao){
                    listSalas.get(i);
                    break;
                }  
            }
            exame.setSala(listSalas.get(i-1));
            listSalas.get(i-1).getExames().add(exame);
            System.out.println("Sala definida!");
        }

    }
    
    public void convoca(ArrayList<Funcionario> listFuncionariosGlobal){
        int opcao, aux, duracao, auxDur, index, quit=0, flag=0;
        Exame exame;
        ArrayList<Exame> exameAux;
        Calendar data, dataAux, dataplus, dataplusAux;
        
        while(true){
            System.out.println("Qual exame?");
            for (int i = 0; i < listExames.size(); i++)
                System.out.println(i+1 + " - " + listExames.get(i).toString());

            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<=listExames.size()) break;
            System.out.println("Opção Inválida");
        }
        
        exame=listExames.get(opcao-1);
        data=exame.getDataHora();
        duracao=exame.getDuracao();
        dataplus=(Calendar)data.clone();
        dataplus.add(Calendar.MINUTE, duracao);
        
        do{
            do{
                index=0;
                for(int i =0; i<listFuncionariosGlobal.size(); i++){
                    if((listFuncionariosGlobal.get(i).getTipo()==true) &&!(exame.getListVigilantes().contains((Docente)listFuncionariosGlobal.get(i)))){
                        exameAux=listFuncionariosGlobal.get(i).getVigilancias();
                        aux=0;
                        for(int j=0; j<exameAux.size(); j++){
                            dataAux=exameAux.get(j).getDataHora();
                            auxDur=exameAux.get(j).getDuracao();
                            dataplusAux=(Calendar) dataAux.clone();
                            dataplusAux.add(Calendar.MINUTE, auxDur);
                            aux+=checkHora(data, dataplus, dataAux, dataplusAux);
                        }
                        if(aux==exameAux.size()){
                            index++;
                            System.out.println(index + " - DOCENTE - " + listFuncionariosGlobal.get(i).getNome());
                        }
                    }
                    else if((listFuncionariosGlobal.get(i).getTipo()==false) && !(exame.getListFuncionarios().contains((NaoDocente)listFuncionariosGlobal.get(i)))){
                        index++;
                        System.out.println(index + " - NÃO DOCENTE - " + listFuncionariosGlobal.get(i).getNome());
                    }   
                }
                if(index==0){
                        System.out.println("Não existem salas diponiveis. Impossivel realizar operação!");
                        quit=1;
                        break;
                }
                else{
                    System.out.print("-> ");
                    opcao=retornaInteiro();
                    if(opcao>0 && opcao<index+1) flag=1;
                    else System.out.println("Opção Inválida");
                }
            }while(flag==0);

            if(quit==0){
                index=0;
                for(int i =0; i<listFuncionariosGlobal.size(); i++){
                    if((listFuncionariosGlobal.get(i).getTipo()==true) &&!(exame.getListVigilantes().contains((Docente)listFuncionariosGlobal.get(i)))){
                        exameAux=listFuncionariosGlobal.get(i).getVigilancias();
                        aux=0;
                        for(int j=0; j<exameAux.size(); j++){
                            dataAux=exameAux.get(j).getDataHora();
                            auxDur=exameAux.get(j).getDuracao();
                            dataplusAux=(Calendar) dataAux.clone();
                            dataplusAux.add(Calendar.MINUTE, auxDur);
                            aux+=checkHora(data, dataplus, dataAux, dataplusAux);
                        }
                        if(aux==exameAux.size()){
                            index++;
                        }
                    }
                    else if((listFuncionariosGlobal.get(i).getTipo()==false) && !(exame.getListFuncionarios().contains((NaoDocente)listFuncionariosGlobal.get(i)))){
                        index++;
                    }
                    if(index==opcao){
                        if(listFuncionariosGlobal.get(i).getTipo()==true){
                            exame.addListDocente((Docente)listFuncionariosGlobal.get(i));
                            listFuncionariosGlobal.get(i).addVigilancias(exame);
                            System.out.println("Docente adicionado com sucesso!");
                        }
                        else{
                            exame.addListNaoDocente((NaoDocente)listFuncionariosGlobal.get(i));
                            listFuncionariosGlobal.get(i).addVigilancias(exame);
                            System.out.println("Não Docente adicionado com sucesso!");
                        }
                    }
                }
                while(true){
                    System.out.print("Quer adicionar mais docentes ou não docente à vigilancia?\n1 - Sim\n2 - Não\n-> ");
                    opcao=retornaInteiro();
                    if(opcao==1 || opcao==2) break;
                    System.out.println("Opção Inválida");
                }
                if(opcao==2) quit=1;
            } 
        }while(quit==0);
    }

    public void addListAlunos(Aluno aluno) {
        this.listAlunos.add(aluno);
    }

    public void addListDocentes(Docente docente) {
        this.listDocentes.add(docente);
    }
    
    private static int verifica_data(int dia, int mes, int ano, int hora, int  min){
        if (((hora<0)||(hora>23))||((min<0)||(min>59))) return 0;
   	if ((dia >= 1) && (mes >= 1 && mes <= 12) && ano>=0){
        if (mes==2){
            if (dia<=28)
                return 1;
            else if (((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))) && dia==29)
                return 1;
        }
        else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia <= 30))
            return 1;
        else if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes ==8 || mes == 10 || mes == 12)&&(dia <=31) )
            return 1;
        }
        return 0;
}
    
    private static int checkHora(Calendar data, Calendar dataplus, Calendar dataAux, Calendar dataplusAux){
        int compare;
        compare = data.compareTo(dataAux);
        if(compare==0) return 0;
        else if(compare <0){ //data antes de data_aux
            compare=dataplus.compareTo(dataAux);
            if(compare==0) return 1;
            else if(compare <0) return 1;
            else return 0;
        }
        else{ //data depois de data_aux
            compare=data.compareTo(dataplusAux);
            if(compare==0) return 1;
            else if(compare <0) return 0;
            else return 1;
        }
    }

    public void imprimeExamesDisciplina() {
        int i, size;
        size = listExames.size();
        for(i=0; i<size; i++){
            System.out.println("\t\t" + i+1 + " - " + listExames.get(i).toString());
        }
    }

    void lancaNotas() {
        int opcao;
        
        while(true){
            System.out.println("Qual exame?");
            for (int i = 0; i < listExames.size(); i++)
                System.out.println(i+1 + " - " + listExames.get(i).toString());

            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<=listExames.size()) break;
            System.out.println("Opção Inválida");
        }
        listExames.get(opcao-1).defineNotas();
    }

    void imprimeFuncionariosExame() {
        int opcao;
        
        while(true){
            System.out.println("Qual exame?");
            for (int i = 0; i < listExames.size(); i++)
                System.out.println(i+1 + " - " + listExames.get(i).toString());

            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<=listExames.size()) break;
            System.out.println("Opção Inválida");
        }
        listExames.get(opcao-1).imprimeFuncionarios();
    }

    void imprimeNotas() {
        int opcao;
        
        while(true){
            System.out.println("Qual exame?");
            for (int i = 0; i < listExames.size(); i++)
                System.out.println(i+1 + " - " + listExames.get(i).toString());

            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<=listExames.size()) break;
            System.out.println("Opção Inválida");
        }
        listExames.get(opcao-1).imprimeNotas();
    }
    
    
}
