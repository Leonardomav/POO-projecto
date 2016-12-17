
package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import static projeto.Projeto.retornaInteiro;
import static projeto.Projeto.retornaString;

public class Curso implements Serializable{
    private String nome, grau;
    private int duracao;
    private ArrayList<Disciplina> listDisciplina = new ArrayList<Disciplina>();
    
    /**
     * @param nome nome do curso
     * @param grau grau do curso
     * @param duracao duraçao do curso em anos
     */
    public Curso(String nome, String grau, int duracao) {
        this.nome = nome;
        this.grau = grau;
        this.duracao = duracao;
    }
    
    /**
     * 
     * @return string de um curso
     */
    @Override
    public String toString() {
        return "Curso{" + "nome=" + nome + ", grau=" + grau + ", duracao=" + duracao + ", listDisciplina=" + listDisciplina + '}';
    }
    
    /**
     * Cria uma disciplina e adicioa à lista de disciplinas do curso.
     * 
     * @param listFuncionariosGlobal lsita global de funcionarios
     */
    public void criaDisciplina(ArrayList<Funcionario> listFuncionariosGlobal){
        int size_func = listFuncionariosGlobal.size();
        int size_disp = listDisciplina.size();
        int opcao, flag;
        String nome_disp;
        Docente auxDocente;
        
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
        
        System.out.println("Pofessor responsável:");
        for (int j = 1; j <= size_func; j++)
            if(listFuncionariosGlobal.get(j-1).getTipo())
                System.out.println(j + " - " + listFuncionariosGlobal.get(j-1).getNome() + " - " + listFuncionariosGlobal.get(j-1).getNumeroMec());

        while(true){
            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<size_func+1) break;
            System.out.println("Opção inválida");
        }
        
        auxDocente = (Docente) listFuncionariosGlobal.get(opcao-1);
        Disciplina nova_disp = new Disciplina(nome_disp, auxDocente);
        listDisciplina.add(nova_disp);
        System.out.println("Disciplina adicionada.");
    }

    /**
     * @return nome do curso
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return lsita de disciplinas do curso.
     */
    public ArrayList<Disciplina> getListDisciplina() {
        return listDisciplina;
    }

    /**
     * adiciona uma disciplina.
     * 
     * @param Disciplina disciplina a adicionar
     */
    public void addListDisciplina(Disciplina Disciplina) {
        this.listDisciplina.add(Disciplina);
    }
    
    /**
     * imprime todos os exames de uma curso.
     */
    void imprimeExamesCurso() {
        int i, size;
        size=listDisciplina.size();
        for(i=0; i<size; i++){
            System.out.println("\tDisciplina: " + listDisciplina.get(i).getNome());
            listDisciplina.get(i).imprimeExamesDisciplina();
        }
    }
  
}
