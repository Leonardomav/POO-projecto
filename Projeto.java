package projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class Projeto {
    
    public static void main(String[] args) {
        ArrayList<Curso> listCursos = new ArrayList<Curso>();
        ArrayList<Aluno> listAlunosGlobal = new ArrayList<Aluno>();
        ArrayList<Docente> listDocentesGlobal = new ArrayList<Docente>();

        criaCurso(listCursos);
        criaAluno(listAlunosGlobal, listCursos);
        criaDocente(listDocentesGlobal);
        addDisciplinas(listCursos, listDocentesGlobal);
        addtoDisp(listCursos, listDocentesGlobal,listAlunosGlobal);
        
        menu(listCursos);
    }
    
    public static void menu(ArrayList<Curso> listCursos){
        int opcao, flag=1;
        while(flag==1){
            System.out.println("----------MENU----------");
            System.out.print("1 - Criar Exame\n2 - Configurar Sala\n3 - Convocar vigilantes ou funcionários\n4 - Inscrever alunos\n5 - Lançar notas\n6 - Listar Exames\n7 - Listar alunos de um exame\n8 - Listar exames de um aluno\n9 - Listar acossiados de um exame\n10 - Listar exames de um funcionário ou docente\n11 - Listar notas de um exame\n0 - Sair\nOpção: ");
            opcao=get_int();
            switch (opcao){
                case 0:
                    flag=0;
                    break;
                case 1: 
                    criar_exame(listCursos);
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
        
    }
    
    public static void criar_exame(ArrayList<Curso> listCursos){
        ArrayList<Disciplina> listDisp;
        int size_cursos=listCursos.size();
        int opcao, size_disp;
        
        while(true){
            System.out.println("Quer adicionar informação a que curso?: ");
            for (int j = 1; j <= size_cursos; j++)
                System.out.println(j + " - " + listCursos.get(j-1).getNome());

            System.out.print("-> ");
            opcao=get_int();
            if(opcao>0 && opcao<size_cursos+1) break;
            System.out.println("Opção Inválida");
        }
        listDisp=listCursos.get(opcao-1).getListDisciplina();
        size_disp=listDisp.size();
                
        while(true){
            System.out.println("Disciplina: ");
            for (int j = 1; j <= size_disp; j++)
                System.out.println(j + " - " + listDisp.get(j-1).getNome());

            System.out.print("-> ");
            opcao=get_int();
            if(opcao>0 && opcao<size_disp+1) break;
            System.out.println("Opção Inválida");
        }
        
        listDisp.get(opcao-1).CriaExame();
        
    }
    
    public static void criaCurso(ArrayList<Curso> listCursos){
        
        int size;
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
                while(true){
                    System.out.print("Duração do curso: ");
                    duracao=get_int();
                    if(duracao > 0) break;
                    System.out.println("Número Inválido");
                }
  
                size = listCursos.size();
                for (int j = 0; j < size; j++){
                    aux_curso = listCursos.get(j);
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
    
    public static void criaAluno(ArrayList<Aluno> listAlunosGlobal, ArrayList<Curso> listCursos){
        int flag, numeroEst, anoMatricula, opcao, num, size_alunos;
        int size_cursos = listCursos.size();
        long numeroFinal;
        Curso aux_curso;
        Aluno aux_aluno;
        String regime, nome,email;
        long aux_long;
        
        
        System.out.print("Quantos Alunos quer criar?\n-> ");
        num=get_int();
        
        for(int i=0; i<num; i++){
            do{
                flag=1;
                System.out.print("Nome do Aluno: ");
                nome=get_string();
                
                System.out.print("Email do Aluno: ");
                email=get_string();
                
                while(true){
                    System.out.print("Numero do Aluno: ");
                    numeroEst=get_int();
                    if((String.valueOf(numeroEst).length())==6) break;
                    System.out.println("Número Inválido");
                }
               
                while(true){
                    System.out.print("Ano de matriculo do Aluno: ");
                    anoMatricula=get_int();
                    if((String.valueOf(anoMatricula).length())==4) break;
                    System.out.println("Número Inválido");
                }
                
                while(true){
                    System.out.print("Regime do Aluno:\n1 - Normal\n2 - Trabalhador-Estudante\n3 - Atleta\n4 - Dirigente associativo\n5 - Erasmus\n-> ");
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
                
                
                for (int j = 1; j <= size_cursos; j++)
                    System.out.println(j + " - " + listCursos.get(j-1).getNome());
                
                
                while(true){
                    System.out.print("-> ");
                    opcao=get_int();
                    if(opcao>0 && opcao<size_cursos+1) break;
                    System.out.println("Opção Inválida");
                }
                
                aux_curso=listCursos.get(opcao-1);
                
                numeroFinal=Long.parseLong("" + anoMatricula + numeroEst);
                
                
                size_alunos = listAlunosGlobal.size();
                for (int j = 0; j < size_alunos; j++){
                    aux_aluno = listAlunosGlobal.get(j);
                    aux_long = aux_aluno.getNumeroEst();
                    if(aux_long==numeroFinal){
                        flag=0;
                        System.out.println("Numero já existe. Insira de novo!");
                    }
                }
            }while(flag==0);
                        
            Aluno novo_aluno = new Aluno(nome, email, numeroFinal, anoMatricula, aux_curso, regime);
            listAlunosGlobal.add(novo_aluno);
            System.out.println("Aluno Adicionado.");
        }
        
    }
    
    public static void criaDocente(ArrayList<Docente> listDocentesGlobal){
        int aux_int, numero, size, flag;
        String areaInv, email, categoria, nome;
        Docente aux_docente;
        
        
        
        System.out.print("Quantos docentes quer criar?\n-> ");
        aux_int=get_int();
        for(int i=0; i<aux_int; i++){
            do{
                flag=1;
                System.out.print("Nome do Docente: ");
                nome=get_string();
                System.out.print("Email do Docente: ");
                email=get_string();
                System.out.print("Area de Investigação do Docente: ");
                areaInv=get_string();
                System.out.print("Numero do Docente: ");
                numero=get_int();
                System.out.print("Categoria do Docente: ");
                categoria=get_string();

                size=listDocentesGlobal.size();
                for(int j=0; i<size;j++){
                    aux_docente=listDocentesGlobal.get(j);
                    if(aux_docente.getNumeroMec()==numero){
                        flag=0;
                        System.out.println("Numero já existe. Insira de novo!");
                    }
                }
            }while(flag==0);
            
            Docente novo_docente = new Docente(nome, email, areaInv, numero, categoria);
            listDocentesGlobal.add(novo_docente);
            System.out.println("Docente Adicionado.");
        }
    }
    
    public void criaNaoDocente(){
        
    }
    
    public static void addDisciplinas(ArrayList<Curso> listCursos,ArrayList<Docente> listDocentesGlobal){
        int opcao, flag;
        int size_cursos=listCursos.size();
        Curso aux_curso;
        
        do{
            flag=1;
            System.out.println("Deseja adicionar disciplinas a que curso?");

            for (int j = 1; j <= size_cursos; j++)
                System.out.println(j + " - " + listCursos.get(j-1).getNome());

            while(true){
                System.out.print("-> ");
                opcao=get_int();
                if(opcao>0 && opcao<size_cursos+1) break;
                System.out.println("Opção Inválida");
            }
            
            aux_curso=listCursos.get(opcao-1);
           
            while(true){
                System.out.print("Quer adicionar quantas disciplinas?\n-> ");
                opcao=get_int();
                if(opcao>0) break;
                System.out.println("Opção Inválida");
            }
            
            for(int j=0; j<opcao; j++){
                aux_curso.criaDisciplina(listDocentesGlobal);
            }
            
            while(true){
                System.out.print("Quer adicionar disciplinas a mais algum curso?\n1 - Sim\n2 - Não\n-> ");
                opcao=get_int();
                if(opcao==1 || opcao==2) break;
                System.out.println("Opção Inválida");
            }
            if(opcao==1) flag=0;
            
        }while(flag==0);
    }
    
    public static void addtoDisp(ArrayList<Curso> listCursos,ArrayList<Docente> listDocentesGlobal, ArrayList<Aluno> listAlunosGlobal){
        int flag, size_cursos, size_disp,opcao;
        ArrayList<Disciplina> listDisp;
        
        
        do{
            flag=1;
            size_cursos=listCursos.size();
                
            while(true){
                System.out.println("Quer adicionar informação a que curso?: ");
                for (int j = 1; j <= size_cursos; j++)
                    System.out.println(j + " - " + listCursos.get(j-1).getNome());
                
                System.out.print("-> ");
                opcao=get_int();
                if(opcao>0 && opcao<size_cursos+1) break;
                System.out.println("Opção Inválida");
            }
            
            listDisp=listCursos.get(opcao-1).getListDisciplina();
            size_disp=listDisp.size();
                
            while(true){
                System.out.println("Disciplina: ");
                for (int j = 1; j <= size_disp; j++)
                    System.out.println(j + " - " + listDisp.get(j-1).getNome());
                
                System.out.print("-> ");
                opcao=get_int();
                if(opcao>0 && opcao<size_disp+1) break;
                System.out.println("Opção Inválida");
            }
            
            listDisp.get(opcao-1).addDocentes(listDocentesGlobal);
            listDisp.get(opcao-1).addAlunos(listAlunosGlobal);
            
            
            while(true){
                System.out.print("Deseja Adicionar algo a mais alguma disciplina?\n1 - Sim\n2 - Não\n-> ");
                opcao=get_int();
                if(opcao==1 || opcao==2) break;
                System.out.println("Opção Inválida");
            }
            if(opcao==1) flag=0;
            
        }while(flag==0);
    }
    
    public void listarExames(){
        
    }
    
    public void criaSala(){
        
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
