package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import static projeto.Projeto.retornaInteiro;

public class ExameNR extends Exame implements Serializable{

    public ExameNR(Calendar dataHora, int duracao, ArrayList<Docente> listVigilantes, int tipo) {
        super(dataHora, duracao, listVigilantes, tipo); //tipo=0 Normal, Tipo=1 Recurso
    }

    @Override
    public Aluno inscreveAluno(ArrayList<Aluno> listAlunos, Disciplina auxDisciplina) {
        int i, opcao, index, sizeAlunos;
        Aluno auxAluno=null;

        sizeAlunos=listAlunos.size();
        if(sizeAlunos==0){
            System.out.println("Não existem alunos.");
            return null;
        }    
        System.out.println("Escolha o aluno: ");
        index=0;
        for(i=0; i<sizeAlunos; i++){
            auxAluno = listAlunos.get(i);
            if(auxDisciplina.getListAlunos().contains(auxAluno) && (!(getListAlunos().contains(auxAluno)))){
                index++;
                System.out.println("Aluno " + index + ": " + auxAluno);
            }
        }
        if(index==0){
            System.out.println("Não existem alunos disponiveis nesta disciplina.");
            return null;
        }
        System.out.print("-> ");
        while(true){
            opcao=retornaInteiro();
            if(opcao>0 && opcao<=index) break;
            System.out.println("Opção inválida");
        }
        index=0;
        for(i=0; i<sizeAlunos; i++){
            auxAluno = listAlunos.get(i);
            if(auxDisciplina.getListAlunos().contains(auxAluno) && !(getListAlunos().contains(auxAluno))){
                index++;
                if(index==opcao){
                    addListAlunos(auxAluno);
                    break;
                }
            }
        }
        return auxAluno;
    }
}
