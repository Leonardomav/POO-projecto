
package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import static projeto.Projeto.retornaInteiro;
import static projeto.Projeto.retornaString;

public class Curso implements Serializable{
    private String nome, grau;
    private int duracao;
    private ArrayList<Disciplina> listDisciplina = new ArrayList<Disciplina>();
    
    public Curso(String nome, String grau, int duracao) {
        this.nome = nome;
        this.grau = grau;
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Curso{" + "nome=" + nome + ", grau=" + grau + ", duracao=" + duracao + ", listDisciplina=" + listDisciplina + '}';
    }
    
    public void criaDisciplina(ArrayList<Funcionario> listFuncionariosGlobal){
        int size_func = listFuncionariosGlobal.size();
        int size_disp = listDisciplina.size();
        int opcao, docenteResp, flag;
        String nome_disp;
        
        do{
            flag=1;
            System.out.print("Nome da disciplina: ");
            nome_disp = retornaString();
            for(int j=0; j<size_disp;j++){
                if(listDisciplina.get(j).getNome().equals(nome_disp)){
                    flag=0;
                    System.out.println("Nome já existe. Insira de novo!");
                    break;
                }
            }
        }while(flag==0);
        
        System.out.println("Pofessor Responsável:");
        for (int j = 1; j <= size_func; j++)
            if(listFuncionariosGlobal.get(j-1).getTipo())
                System.out.println(j + " - " + listFuncionariosGlobal.get(j-1).getNome() + " - " + listFuncionariosGlobal.get(j-1).getNumeroMec());

        while(true){
            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<size_func+1) break;
            System.out.println("Opção Inválida");
        }
        
        docenteResp = listFuncionariosGlobal.get(opcao-1).getNumeroMec();
        Disciplina nova_disp = new Disciplina(nome_disp, docenteResp);
        listDisciplina.add(nova_disp);
        System.out.println("Disciplina Adicionada.");
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Disciplina> getListDisciplina() {
        return listDisciplina;
    }

    public void addListDisciplina(Disciplina Disciplina) {
        this.listDisciplina.add(Disciplina);
    }
  
}
