
package projeto;

import java.util.ArrayList;

public class Curso {
    private String nome, grau;
    private int duracao;
    private ArrayList<Disciplina> listDisciplina;
    
    public void criaDisciplinas(){
        
    }

    public Curso(String nome, String grau, int duracao, ArrayList<Disciplina> listDisciplina) {
        this.nome = nome;
        this.grau = grau;
        this.duracao = duracao;
        this.listDisciplina = listDisciplina;
    }
    
}
