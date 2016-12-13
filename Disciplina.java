
package projeto;

import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private Docente docenteResp;
    private ArrayList<Aluno> listAlunos;
    private ArrayList<Docente> docentes;
    private ArrayList<Exame> listExames;

    public Disciplina(String nome, Docente docenteResp, ArrayList<Docente> docentes, ArrayList<Exame> listExames) {
        this.nome = nome;
        this.docenteResp = docenteResp;
        this.docentes = docentes;
        this.listExames = listExames;
    }
    
    
    public void AddExame(){
        
    }
}
