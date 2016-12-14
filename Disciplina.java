
package projeto;

import java.util.ArrayList;
import static projeto.Projeto.get_int;

public class Disciplina {
    private String nome;
    private int docenteResp;
    private ArrayList<Long> listAlunos = new ArrayList<Long>();
    private ArrayList<Integer> listDocentes = new ArrayList<Integer>();
    private ArrayList<Exame> listExames;

    public Disciplina(String nome, int docenteResp) {
       this.nome=nome;
       this.docenteResp=docenteResp;
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
            System.out.print("-> ");
            while(true){
                opcao=get_int();
                if(opcao>0 && opcao<size_global+1) break;
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
            System.out.println("Deseja adicionar mais algum docente a esta disciplina?\n1 - Sim\n2 - Não\n->");
            while(true){
                opcao=get_int();
                if(opcao==1 || opcao==2) break;
                System.out.println("Opção Inválida");
            }
            if(opcao==2) flag=0;
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
            while(true){
                opcao=get_int();
                if(opcao>0 && opcao<size_global+1) break;
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
            System.out.println("Deseja adicionar mais algum aluno a esta disciplina?\n1 - Sim\n2 - Não\n->");
            while(true){
                opcao=get_int();
                if(opcao==1 || opcao==2) break;
                System.out.println("Opção Inválida");
            }
            if(opcao==2) flag=0;
        }
    }
    
    public void CriaExame(){
        
    }
}
