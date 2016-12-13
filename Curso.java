
package projeto;

import java.util.ArrayList;

public class Curso {
    private String nome, grau;
    private int duracao;
    private ArrayList<Disciplina> listDisciplina;
    
    public void criaDisciplinas(){
        int flag=0;

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
