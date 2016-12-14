
package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import static projeto.Projeto.get_int;
import static projeto.Projeto.get_string;

public class Curso implements Serializable{
    private String nome, grau;
    private int duracao;
    private ArrayList<Disciplina> listDisciplina = new ArrayList<Disciplina>();
    
    public void criaDisciplina(ArrayList<Docente> listDocenteGlobal){
        int size_docente = listDocenteGlobal.size();
        int size_disp = listDisciplina.size();
        int opcao, docenteResp, flag;
        String nome_disp;
        
        do{
            flag=1;
            System.out.print("Nome da disciplina: ");
            nome_disp = get_string();
            for(int j=0; j<size_disp;j++){
                if(listDisciplina.get(j).getNome().equals(nome_disp)){
                    flag=0;
                    System.out.println("Nome já existe. Insira de novo!");
                    break;
                }
            }
        }while(flag==0);
        
        System.out.println("Pofessor Responsável:");
        for (int j = 1; j <= size_docente; j++)
            System.out.println(j + " - " + listDocenteGlobal.get(j-1).getNome() + " - " + listDocenteGlobal.get(j-1).getNumeroMec());

        while(true){
            System.out.print("-> ");
            opcao=get_int();
            if(opcao>0 && opcao<size_docente+1) break;
            System.out.println("Opção Inválida");
        }
        
        docenteResp = listDocenteGlobal.get(opcao-1).getNumeroMec();
        Disciplina nova_disp = new Disciplina(nome_disp, docenteResp);
        listDisciplina.add(nova_disp);
        System.out.println("Disciplina Adicionada.");
    }

    public Curso(String nome, String grau, int duracao) {
        this.nome = nome;
        this.grau = grau;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Disciplina> getListDisciplina() {
        return listDisciplina;
    }
    
    
    
    
}
