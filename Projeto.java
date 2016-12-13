package projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class Projeto {

    public static void main(String[] args) {
        ArrayList<Curso> listCursos = new ArrayList<Curso>();
        ArrayList<Aluno> listAlunosGlobal = new ArrayList<Aluno>();
        
        
        criaCurso(listCursos);
        criaAluno(listAlunosGlobal, listCursos);
        
        menu(listCursos);
    }
    
    public static void menu(ArrayList<Curso> listCursos){
        int opcao;
        System.out.println("----------MENU----------");
        System.out.print("1 - Criar Exame\n2 - Configurar Sala\n3 - Convocar vigilantes ou funcionários\n4 - Inscrever alunos\n5 - Lançar notas\n6 - Listar Exames\n7 - Listar alunos de um exame\n8 - Listar exames de um aluno\n 9 - Listar acossiados de um exame\n10 - Listar exames de um funcionário ou docente\n11 - Listar notas de um exame\nOpção: ");
        opcao=get_int();
        switch (opcao){
            case 1: 
                //criar_exame();
                break;
            case 2: 
                //criar_exame();
                break;
            case 3: 
                //criar_exame();
                break;
            case 4: 
                //criar_exame();
                break;
            case 5: 
                //criar_exame();
                break;
            case 6: 
                //criar_exame();
                break;
            case 7: 
                //criar_exame();
                break;
            case 8: 
                //criar_exame();
                break;
            case 9: 
                //criar_exame();
                break;
            case 10: 
                //criar_exame();
                break;
            case 11: 
                //criar_exame();
                break;
            default: 
                System.out.println("Opção inválida");
        }
        
        
    }
    
    public static void criaCurso(ArrayList<Curso> listCursos){
        
        int size = listCursos.size();
        Curso aux_curso;
        
        String nome, grau, aux_nome;
        int duracao, flag, aux_int;
        
        System.out.print("Quantos cursos quer criar?\n-> ");
        aux_int=get_int();
        
        for(int i = 0; i < aux_int; i++){
            do{
                flag=1;
                System.out.print("Nome do curso: ");
                nome=get_string();
                System.out.print("Grau do curso: ");
                grau=get_string();
                System.out.print("Duração do curso: ");
                duracao=get_int();
                for (i = 0; i < size; i++){
                    aux_curso = listCursos.get(i);
                    aux_nome=aux_curso.getNome();
                    if(aux_nome.equals(nome)){
                        flag=0;
                        System.out.println("Curso já existe. Insira de novo!");
                    }
                }
            }while(flag==0);
            Curso novo_curso = new Curso(nome, grau, duracao);
            listCursos.add(novo_curso);
            System.out.println("Curso Adicionado.");
        }
    }
    
    public void criaSala(){
        
    }
    
    public static void criaAluno(ArrayList<Aluno> listAlunosGlobal, ArrayList<Curso> listCursos){
        int aux_int, flag, numeroEst, anoMatricula, numeroFinal, opcao, num;
        int size_cursos = listCursos.size();
        int size_alunos = listAlunosGlobal.size();
        Curso aux_curso;
        Aluno aux_aluno;
        String regime;
        
        
        System.out.print("Quantos Alunos quer criar?\n-> ");
        num=get_int();
        
        for(int i=0; i<num; i++){
            do{
                flag=1;
                
                System.out.print("Numero do Aluno: ");
                while(true){
                    numeroEst=get_int();
                    if((String.valueOf(numeroEst).length())==6) break;
                    System.out.println("Número Inválido");
                }
                
                System.out.print("Ano de matriculo do Aluno: ");
                while(true){
                    anoMatricula=get_int();
                    if((String.valueOf(anoMatricula).length())==3) break;
                    System.out.println("Número Inválido");
                }
                
                System.out.print("Regime do Aluno:\n1 - Normal\n2 - Trabalhador-Estudante\n3 - Atleta\n4 - Dirigente associativo\n5 - Erasmus");
                while(true){
                    opcao=get_int();
                    if(opcao>0 && opcao<6) break;
                    System.out.println("Opção Inválida");
                }
                switch(opcao){
                    case 1:
                        regime="Normal";
                        break;
                    case 2: 
                        regime="Trabalhador-Estudante";
                        break;
                    case 3:
                        regime="Atleta";
                        break;
                    case 4:
                        regime="Dirigente associativo";
                        break;
                    case 5:
                        regime="Erasmos";
                        break;
                    default:
                        regime="Normal";
                        break;
                }
                
                
                for (i = 0; i < size_cursos; i++)
                    System.out.println(i + " - " + listCursos.get(i));
                
                while(true){
                    opcao=get_int();
                    if(opcao>0 && opcao<size_cursos) break;
                    System.out.println("Opção Inválida");
                }
                
                aux_curso=listCursos.get(i);
                numeroFinal=Integer.parseInt("" + anoMatricula + numeroEst);
                
                for (i = 0; i < size_alunos; i++){
                    aux_aluno = listAlunosGlobal.get(i);
                    aux_int = aux_aluno.getNumeroEst();
                    if(aux_int==numeroFinal){
                        flag=0;
                        System.out.println("Curso já existe. Insira de novo!");
                    }
                }
            }while(flag==0);
                        
            Aluno novo_aluno = new Aluno(numeroFinal, anoMatricula, aux_curso, regime);
            listAlunosGlobal.add(novo_aluno);
            System.out.println("Aluno Adicionado.");
        }
        
    }
    
    public void criaDocente(){
        
    }
    
    public void criaNaoDocente(){
        
    }
    
    public void listarExames(){
        
    }
    
    public static int get_int(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    public static String get_string(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
}
