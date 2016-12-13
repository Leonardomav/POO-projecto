
package projeto;

import java.util.ArrayList;
import static projeto.Projeto.get_int;
import static projeto.Projeto.get_string;

public class Curso {
    private String nome, grau;
    private int duracao;
    private ArrayList<Disciplina> listDisciplina;
    
    public void criaDisciplina(ArrayList<Docente> listDocenteGlobal){
        int size = listDocenteGlobal.size();
        int opcao, docenteResp;
        
        System.out.print("Nome da disciplina: ");
        nome = get_string();
        
        System.out.println("Pofessor Responsável:");
        for (int j = 1; j <= size; j++)
            System.out.println(j + " - " + listDocenteGlobal.get(j-1).getNome() + " - " + listDocenteGlobal.get(j-1).getNumeroMec());
        System.out.print("-> ");

        while(true){
            opcao=get_int();
            if(opcao>0 && opcao<size+1) break;
            System.out.println("Opção Inválida");
        }
        
        docenteResp = listDocenteGlobal.get(opcao-1).getNumeroMec();
        
        Disciplina nova_disp = new Disciplina(nome, docenteResp);
        
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
    
    
}
