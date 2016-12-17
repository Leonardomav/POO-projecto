package projeto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Projeto {
    
    public static void main(String[] args) {
        ArrayList<Curso> listCursosGlobal = new ArrayList<Curso>();
        ArrayList<Aluno> listAlunosGlobal = new ArrayList<Aluno>();
        ArrayList<Funcionario> listFuncionariosGlobal = new ArrayList<Funcionario>();
        ArrayList<Sala> listSalas = new ArrayList<Sala>();

        //carregarDeFicheiro(listCursosGlobal, listAlunosGlobal, listFuncionariosGlobal);
        
        //hardcode para testes
        
        listCursosGlobal.add(new Curso("LEI", "Mestrado", 5));
        Aluno leo = new Aluno("Leonardo", "Sapo", 1111111111L, 2015, listCursosGlobal.get(0), "Normal");
        listAlunosGlobal.add(leo);
        Aluno tiago = new Aluno("Tiago", "Gmail",2222222222L, 2015, listCursosGlobal.get(0), "Normal");
        listAlunosGlobal.add(tiago);
        Aluno artur = new Aluno("Artur", "Yahoo",3333333333L, 2014, listCursosGlobal.get(0), "Normal");
        listAlunosGlobal.add(artur);
        Aluno outro = new Aluno("O outro", "Dali",4444444444L, 2012, listCursosGlobal.get(0), "Normal");
        listAlunosGlobal.add(outro);
        Docente ernesto = new Docente("Ernesto", "lol", "lol", 1, "lol");
        listFuncionariosGlobal.add(ernesto);
        Docente cordeiro = new Docente("Cordeiro", "lol", "lol", 2, "lol");
        listFuncionariosGlobal.add(cordeiro);
        Docente vasco = new Docente("Vasco", "lol", "lol", 3, "lol");
        listFuncionariosGlobal.add(vasco);
        Docente douradinho = new Docente("Douradinho", "lol", "lol", 4, "lol");
        listFuncionariosGlobal.add(douradinho);
        listCursosGlobal.get(0).addListDisciplina(new Disciplina("IPRP", ernesto));
        listCursosGlobal.get(0).addListDisciplina(new Disciplina("POO", cordeiro));
        listCursosGlobal.get(0).addListDisciplina(new Disciplina("PPP", vasco));
        listCursosGlobal.get(0).getListDisciplina().get(0).addListAlunos(leo);
        listCursosGlobal.get(0).getListDisciplina().get(0).addListAlunos(tiago);
        listCursosGlobal.get(0).getListDisciplina().get(1).addListAlunos(leo);
        listCursosGlobal.get(0).getListDisciplina().get(1).addListAlunos(tiago);
        listCursosGlobal.get(0).getListDisciplina().get(0).addListDocentes(cordeiro);
        listCursosGlobal.get(0).getListDisciplina().get(1).addListDocentes(ernesto);
        listSalas.add(new Sala("DEI", 1));
        listSalas.add(new Sala("DEI", 2));
        listSalas.add(new Sala("DEI", 3));
        

//        System.out.println(listCursosGlobal);
//        System.out.println(listAlunosGlobal);
//        System.out.println(listFuncionariosGlobal);
        
        menu(listCursosGlobal,listAlunosGlobal,listFuncionariosGlobal, listSalas);
        
        guardarEmFicheiro(listCursosGlobal, listAlunosGlobal, listFuncionariosGlobal);
        
    }
    
    private static void menu(ArrayList<Curso> listCursosGlobal, ArrayList<Aluno> listAlunosGlobal, ArrayList<Funcionario> listFuncionariosGlobal, ArrayList<Sala> listSalas){
        int opcao, flag=1;
        while(flag==1){
            System.out.println("----------MENU----------");
            System.out.print("99 - ADMIN\n1 - Criar Exame\n2 - Configurar Sala\n3 - Convocar vigilantes ou funcionários\n4 - Inscrever alunos\n5 - Lançar notas\n6 - Listar Exames\n7 - Listar alunos de um exame\n8 - Listar exames de um aluno\n9 - Listar acossiados de um exame\n10 - Listar exames de um funcionário ou docente\n11 - Listar notas de um exame\n0 - Sair\nOpção: ");
            opcao=retornaInteiro();
            switch (opcao){
                case 99:
                    setup(listCursosGlobal,listAlunosGlobal,listFuncionariosGlobal);
                    break;
                case 0:
                    flag=0;
                    break;
                case 1: 
                    criar_exame(listCursosGlobal,listFuncionariosGlobal );
                    break;
                case 2: 
                    //criar_exame();
                    break;
                case 3: 
                    //criar_exame();
                    break;
                case 4: 
                    inscreverAlunoExame(listCursosGlobal, listAlunosGlobal);
                    break;
                case 5: 
                    //criar_exame();
                    break;
                case 6: 
                    listarExames(listCursosGlobal);
                    break;
                case 7: 
                    listarAlunosDeExame(listCursosGlobal);
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
                    break;
            }
            System.out.print("Clique enter para continuar");
            esperaEnter();
        }
        
    }
    
    private static void criar_exame(ArrayList<Curso> listCursosGlobal, ArrayList<Funcionario> listFuncionariosGlobal){
        ArrayList<Disciplina> listDisp;
        int size_cursos=listCursosGlobal.size();
        int opcao, size_disp;
        
        while(true){
            System.out.println("Quer adicionar um exame a que curso?: ");
            for (int j = 1; j <= size_cursos; j++)
                System.out.println(j + " - " + listCursosGlobal.get(j-1).getNome());

            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<size_cursos+1) break;
            System.out.println("Opção Inválida");
        }
        listDisp=listCursosGlobal.get(opcao-1).getListDisciplina();
        size_disp=listDisp.size();
                
        while(true){
            System.out.println("A que disciplina?");
            for (int j = 1; j <= size_disp; j++)
                System.out.println(j + " - " + listDisp.get(j-1).getNome());

            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<size_disp+1) break;
            System.out.println("Opção Inválida");
        }
        
        listDisp.get(opcao-1).criaExame(listFuncionariosGlobal);
        System.out.println("Exame criado e adicionado.");
    }
    
    private static void criaCurso(ArrayList<Curso> listCursosGlobal){
        
        int size;
        Curso aux_curso;
        
        String nome, grau, aux_nome;
        int duracao, flag, aux_int;
        
        System.out.print("Quantos cursos quer criar?\n-> ");
        aux_int=retornaInteiro();
        
        for(int i = 0; i < aux_int; i++){
            do{
                flag=1;
                System.out.print("Nome do curso: ");
                nome=retornaString();
                System.out.print("Grau do curso: ");
                grau=retornaString();
                while(true){
                    System.out.print("Duração do curso: ");
                    duracao=retornaInteiro();
                    if(duracao > 0) break;
                    System.out.println("Número Inválido");
                }
  
                size = listCursosGlobal.size();
                for (int j = 0; j < size; j++){
                    aux_curso = listCursosGlobal.get(j);
                    aux_nome=aux_curso.getNome();
                    if(aux_nome.equals(nome)){
                        flag=0;
                        System.out.println("Curso já existe. Insira de novo!");
                    }
                }
            }while(flag==0);
            Curso novo_curso = new Curso(nome, grau, duracao);
            listCursosGlobal.add(novo_curso);
            System.out.println("Curso Adicionado.");
        }
    }
    
    private static void criaAluno(ArrayList<Aluno> listAlunosGlobal, ArrayList<Curso> listCursosGlobal){
        int flag, numeroEst, anoMatricula, opcao, num, size_alunos;
        int size_cursos = listCursosGlobal.size();
        long numeroFinal;
        Curso aux_curso;
        Aluno aux_aluno, novo_aluno;
        String regime, nome,email;
        long aux_long;
        
        
        System.out.print("Quantos Alunos quer criar?\n-> ");
        num=retornaInteiro();
        
        for(int i=0; i<num; i++){
            do{
                flag=1;
                System.out.print("Nome do aluno: ");
                nome=retornaString();
                
                System.out.print("Email do aluno: ");
                email=retornaString();
                
                while(true){
                    System.out.print("Numero do aluno: ");
                    numeroEst=retornaInteiro();
                    if((String.valueOf(numeroEst).length())==6) break;
                    System.out.println("Número inválido");
                }
               
                while(true){
                    System.out.print("Ano de matriculo do aluno: ");
                    anoMatricula=retornaInteiro();
                    if((String.valueOf(anoMatricula).length())==4) break;
                    System.out.println("Número inválido");
                }
                
                while(true){
                    System.out.print("Regime do aluno:\n1 - Normal\n2 - Trabalhador-Estudante\n3 - Atleta\n4 - Dirigente associativo\n5 - Erasmus\n-> ");
                    opcao=retornaInteiro();
                    if(opcao>0 && opcao<6) break;
                    System.out.println("Opção inválida");
                }
                switch(opcao){
                    case 1:
                        regime="Normal";
                        break;
                    case 2: 
                        regime="Trabalhador-estudante";
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
                    System.out.println(j + " - " + listCursosGlobal.get(j-1).getNome());
                
                
                while(true){
                    System.out.print("-> ");
                    opcao=retornaInteiro();
                    if(opcao>0 && opcao<size_cursos+1) break;
                    System.out.println("Opção inválida");
                }
                
                aux_curso=listCursosGlobal.get(opcao-1);
                
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
                        
            novo_aluno  = new Aluno(nome, email, numeroFinal, anoMatricula, aux_curso, regime);
            listAlunosGlobal.add(novo_aluno);
            System.out.println("Aluno adicionado.");
        }
        
    }
    private static void criaDocente(ArrayList<Funcionario> listFuncionariosGlobal){
        int aux_int, numero, size, flag;
        String areaInv, email, categoria, nome;
        Funcionario auxFuncionario;
        Docente novo_docente;
        
        
        System.out.print("Quantos docentes quer criar?\n-> ");
        aux_int=retornaInteiro();
        for(int i=0; i<aux_int; i++){
            do{
                flag=1;
                System.out.print("Nome do docente: ");
                nome=retornaString();
                System.out.print("Email do docente: ");
                email=retornaString();
                System.out.print("Area de Investigação do docente: ");
                areaInv=retornaString();
                System.out.print("Numero do docente: ");
                numero=retornaInteiro();
                System.out.print("Categoria do docente: ");
                categoria=retornaString();

                size=listFuncionariosGlobal.size();
                for(int j=0; j<size;j++){
                    auxFuncionario=listFuncionariosGlobal.get(j);
                    if(auxFuncionario.getNumeroMec()==numero){

                        flag=0;
                        System.out.println("Numero já existe. Insira de novo!");
                    }
                }
            }while(flag==0);
            
            novo_docente = new Docente(nome, email, areaInv, numero, categoria);
            listFuncionariosGlobal.add(novo_docente);
            System.out.println("Docente adicionado.");

        }
    }

    private static void criaNaoDocente(ArrayList<Funcionario> listFuncionariosGlobal) {
        int aux_int, numero, size, flag;
        String cargo, email, categoria, nome;
        Funcionario auxFuncionario;
        NaoDocente novo_NaoDocente;
        
        
        
        System.out.print("Quantos nao-docentes quer criar?\n-> ");
        aux_int=retornaInteiro();
        for(int i=0; i<aux_int; i++){
            do{
                flag=1;
                System.out.print("Nome do nao-docente: ");
                nome=retornaString();
                System.out.print("Email do nao-docente: ");
                email=retornaString();
                System.out.print("Cargo do nao-docente: ");
                cargo=retornaString();
                System.out.print("Numero do nao-docente: ");
                numero=retornaInteiro();
                System.out.print("Categoria do nao-docente: ");
                categoria=retornaString();

                size=listFuncionariosGlobal.size();
                for(int j=0; j<size;j++){
                    auxFuncionario=(NaoDocente)listFuncionariosGlobal.get(j);
                    if(auxFuncionario.getNumeroMec()==numero){
                        flag=0;
                        System.out.println("Numero já existe. Insira de novo!");
                    }
                }
            }while(flag==0);
            
            novo_NaoDocente = new NaoDocente(nome, email, cargo, numero, categoria);
            listFuncionariosGlobal.add(novo_NaoDocente);
            System.out.println("Nao-docente Adicionado.");
        }
    }
    
    private static void addDisciplinas(ArrayList<Curso> listCursosGlobal,ArrayList<Funcionario> listFuncionariosGlobal){
        int opcao, flag;
        int size_cursos=listCursosGlobal.size();
        Curso aux_curso;
        
        do{
            flag=1;
            System.out.println("Deseja adicionar disciplinas a que curso?");

            for (int j = 1; j <= size_cursos; j++)
                System.out.println(j + " - " + listCursosGlobal.get(j-1).getNome());

            while(true){
                System.out.print("-> ");
                opcao=retornaInteiro();
                if(opcao>0 && opcao<size_cursos+1) break;
                System.out.println("Opção Inválida");
            }
            
            aux_curso=listCursosGlobal.get(opcao-1);
           
            while(true){
                System.out.print("Quer adicionar quantas disciplinas?\n-> ");
                opcao=retornaInteiro();
                if(opcao>0) break;
                System.out.println("Opção Inválida");
            }
            
            for(int j=0; j<opcao; j++){
                aux_curso.criaDisciplina(listFuncionariosGlobal);
            }
            
            while(true){
                System.out.print("Quer adicionar disciplinas a mais algum curso?\n1 - Sim\n2 - Não\n-> ");
                opcao=retornaInteiro();
                if(opcao==1 || opcao==2) break;
                System.out.println("Opção Inválida");
            }
            if(opcao==1) flag=0;
            
        }while(flag==0);
    }
    
    private static void addtoDisp(ArrayList<Curso> listCursosGlobal, ArrayList<Funcionario> listFuncionariosGlobal, ArrayList<Aluno> listAlunosGlobal){
        int flag, size_cursos, size_disp,opcao;
        ArrayList<Disciplina> listDisp;
        
        
        do{
            flag=1;
            size_cursos=listCursosGlobal.size();
                
            while(true){
                System.out.println("Quer adicionar informação a que curso?: ");
                for (int j = 1; j <= size_cursos; j++)
                    System.out.println(j + " - " + listCursosGlobal.get(j-1).getNome());
                
                System.out.print("-> ");
                opcao=retornaInteiro();
                if(opcao>0 && opcao<size_cursos+1) break;
                System.out.println("Opção inválida");
            }
            
            listDisp=listCursosGlobal.get(opcao-1).getListDisciplina();
            size_disp=listDisp.size();
                
            while(true){
                System.out.println("Disciplina: ");
                for (int j = 1; j <= size_disp; j++)
                    System.out.println(j + " - " + listDisp.get(j-1).getNome());
                
                System.out.print("-> ");
                opcao=retornaInteiro();
                if(opcao>0 && opcao<size_disp+1) break;
                System.out.println("Opção inválida");
            }
            
            listDisp.get(opcao-1).addDocentes(listFuncionariosGlobal);
            listDisp.get(opcao-1).addAlunos(listAlunosGlobal);
            
            
            while(true){
                System.out.print("Deseja adicionar algo a mais alguma disciplina?\n1 - Sim\n2 - Não\n-> ");
                opcao=retornaInteiro();
                if(opcao==1 || opcao==2) break;
                System.out.println("Opção Inválida");
            }
            if(opcao==1) flag=0;
            
        }while(flag==0);
    }

    private static void listarExames(ArrayList<Curso> listCursosGlobal) {
        int i, size;
        size = listCursosGlobal.size();
        for(i=0; i<size; i++){
            System.out.println("Curso: " + listCursosGlobal.get(i).getNome());
            listCursosGlobal.get(i).imprimeExamesCurso();
        }
    }

    private static void listarAlunosDeExame(ArrayList<Curso> listCursosGlobal) {
        int i, opcao, sizeCursos, sizeDisp, sizeExames, sizeAlunos, sizeNotas;
        ArrayList<Disciplina> listDisp;
        ArrayList<Exame> listExam;
        ArrayList<Aluno> listAlun;
        ArrayList<Float> listNotas;
        Exame auxExame;
        
        sizeCursos=listCursosGlobal.size();
        if(sizeCursos==0){
            System.out.println("Não existem cursos.");
            return;
        }
        while(true){
            System.out.println("Escolha o curso do exame: ");
            for (i = 0; i<sizeCursos; i++)
                System.out.println(i+1 + " - " + listCursosGlobal.get(i).getNome());

            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<sizeCursos+1) break;
            System.out.println("Opção inválida");
        }

        listDisp=listCursosGlobal.get(opcao-1).getListDisciplina();
        
        sizeDisp=listDisp.size();
        if(sizeDisp==0){
            System.out.println("Não existem disciplinas no curso escolhido.");
            return;
        }
        while(true){
            System.out.println("Escolha a disciplina do exame: ");
            for (i=0; i<sizeDisp; i++)
                System.out.println(i+1 + " - " + listDisp.get(i).getNome());

            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<sizeDisp+1) break;
            System.out.println("Opção inválida");
        }


        listExam = listDisp.get(opcao-1).getListExames();
        
        sizeExames=listExam.size();
        if(sizeExames==0){
            System.out.println("Não existem exames na disciplina escolhida.");
            return;
        }        
        while(true){
            System.out.println("Escolha o exame: ");
            for (i=0; i<sizeExames; i++)
                System.out.println(i+1 + " - " + listExam.get(i));

            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<sizeExames+1) break;
            System.out.println("Opção inválida");
        }
        
        auxExame = listExam.get(opcao-1);
        
        listAlun = auxExame.getListAlunos();
        listNotas = auxExame.getListNotas();
        
        sizeAlunos=listAlun.size();
        sizeNotas=listNotas.size();
        
        if(sizeAlunos==0){
            System.out.println("Não existem alunos inscritos neste exame.");
            return;
        }    
        for (i=0; i<sizeAlunos; i++){
            System.out.println("Aluno " + i + ": " + listAlun.get(i));
            if(sizeNotas!=0){
                System.out.println("\tNota: " + listNotas.get(i));
            }
            System.out.println("");
        }
    }

    private static void inscreverAlunoExame(ArrayList<Curso> listCursosGlobal, ArrayList<Aluno> listAlunosGlobal) {
        int i, opcao, sizeCursos, sizeDisp, sizeExames;
        ArrayList<Disciplina> listDisp;
        ArrayList<Exame> listExam;
        Disciplina auxDisciplina;
        Exame auxExame;
        Aluno auxAluno;
        
        sizeCursos=listCursosGlobal.size();
        if(sizeCursos==0){
            System.out.println("Não existem cursos.");
            return;
        }
        while(true){
            System.out.println("Escolha o curso do exame: ");
            for (i = 0; i<sizeCursos; i++)
                System.out.println(i+1 + " - " + listCursosGlobal.get(i).getNome());

            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<sizeCursos+1) break;
            System.out.println("Opção inválida");
        }

        listDisp=listCursosGlobal.get(opcao-1).getListDisciplina();
        
        sizeDisp=listDisp.size();
        if(sizeDisp==0){
            System.out.println("Não existem disciplinas no curso escolhido.");
            return;
        }
        while(true){
            System.out.println("Escolha a disciplina do exame: ");
            for (i=0; i<sizeDisp; i++)
                System.out.println(i+1 + " - " + listDisp.get(i).getNome());

            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<sizeDisp+1) break;
            System.out.println("Opção inválida");
        }

        auxDisciplina = listDisp.get(opcao-1);
        listExam = auxDisciplina.getListExames();
        
        sizeExames=listExam.size();
        if(sizeExames==0){
            System.out.println("Não existem exames na disciplina escolhida.");
            return;
        }        
        while(true){
            System.out.println("Escolha o exame: ");
            for (i=0; i<sizeExames; i++)
                System.out.println(i+1 + " - " + listExam.get(i));

            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<sizeExames+1) break;
            System.out.println("Opção inválida");
        }
        
        auxExame = listExam.get(opcao-1);
        auxAluno=auxExame.inscreveAluno(listAlunosGlobal, auxDisciplina);
        if(auxAluno==null)
            return;
        auxAluno.addListInscricoes(auxExame);
    }
    
    private void criaSala(){
        
    }
    
    public static int retornaInteiro(){
        Scanner sc = new Scanner(System.in);
        String aux;
        int num;
        while (true) {
            aux = sc.nextLine();
            try {
                num = Integer.parseInt(aux);
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Input inválido. Introduza um inteiro: ");
            }
        }
    }
    
    public static String retornaString(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
    private static void esperaEnter(){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        return;
    }
    
    private static void guardarEmFicheiro(ArrayList<Curso> listCursosGlobal, ArrayList<Aluno> listAlunosGlobal, ArrayList<Funcionario> listFuncionariosGlobal){
        FicheiroDeObjectos fo = new FicheiroDeObjectos();
        
        fo.abreEscrita("cursos.dat");
        fo.escreveObjecto(listCursosGlobal);
        fo.fechaEscrita();
        
        fo.abreEscrita("alunos.dat");
        fo.escreveObjecto(listAlunosGlobal);
        fo.fechaEscrita();
        
        fo.abreEscrita("funcionarios.dat");
        fo.escreveObjecto(listFuncionariosGlobal);
        fo.fechaEscrita();
        
    }
    
    private static void carregarDeFicheiro(ArrayList<Curso> listCursosGlobal, ArrayList<Aluno> listAlunosGlobal, ArrayList<Funcionario> listFuncionariosGlobal) {
        FicheiroDeObjectos fo = new FicheiroDeObjectos();
        
        fo.abreLeitura("cursos.dat");
        listCursosGlobal.addAll((ArrayList<Curso>) fo.leObjecto());
        fo.fechaLeitura();
        
        fo.abreLeitura("alunos.dat");
        listAlunosGlobal.addAll((ArrayList<Aluno>) fo.leObjecto());
        fo.fechaLeitura();
        
        fo.abreLeitura("funcionarios.dat");
        listFuncionariosGlobal.addAll((ArrayList<Funcionario>) fo.leObjecto());
        fo.fechaLeitura();
        
    }
    
    private static void setup(ArrayList<Curso> listCursosGlobal, ArrayList<Aluno> listAlunosGlobal, ArrayList<Funcionario> listFuncionariosGlobal){
//        criaCurso(listCursosGlobal);
//        criaAluno(listAlunosGlobal, listCursosGlobal);
//        criaDocente(listFuncionariosGlobal);
//        criaNaoDocente(listFuncionariosGlobal);
//        addDisciplinas(listCursosGlobal, listFuncionariosGlobal);
        addtoDisp(listCursosGlobal, listFuncionariosGlobal,listAlunosGlobal);
    }
}
