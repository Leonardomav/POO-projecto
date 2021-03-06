package projeto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Projeto {
    
    /**
    * Função main à qual se faz a primeira chamada.
    */
    public static void main(String[] args) {
        ArrayList<Curso> listCursosGlobal = new ArrayList<Curso>();
        ArrayList<Aluno> listAlunosGlobal = new ArrayList<Aluno>();
        ArrayList<Funcionario> listFuncionariosGlobal = new ArrayList<Funcionario>();
        ArrayList<Sala> listSalas = new ArrayList<Sala>();

//        carregarDeFicheiro(listCursosGlobal, listAlunosGlobal, listFuncionariosGlobal, listSalas);
        
        //hardcode para testes
        
        listCursosGlobal.add(new Curso("LEI", "Mestrado", 5));
        Aluno joao = new Aluno("Joao", "joao@sapo.pt", 1111111111L, 2015, listCursosGlobal.get(0), "Normal");
        listAlunosGlobal.add(joao);
        Aluno pedro = new Aluno("Pedro", "pedro@gmail.com",2222222222L, 2015, listCursosGlobal.get(0), "Normal");
        listAlunosGlobal.add(pedro);
        Aluno jose = new Aluno("Jose", "jose@yahoo.com",3333333333L, 2014, listCursosGlobal.get(0), "Atleta");
        listAlunosGlobal.add(jose);
        Aluno miguel = new Aluno("Miguel", "miguel@hotmail.com",4444444444L, 2012, listCursosGlobal.get(0), "Ultimo ano");
        listAlunosGlobal.add(miguel);
        Docente carlos = new Docente("Carlos", "carlos@abc.com", "Robotica", 1, "Catedratico");
        listFuncionariosGlobal.add(carlos);
        Docente paulo = new Docente("Paulo", "paulo@aaa.com", "Redes", 2, "Auxiliar");
        listFuncionariosGlobal.add(paulo);
        Docente vasco = new Docente("Vasco", "vasco@bbb.com", "IA", 3, "Subsituto");
        listFuncionariosGlobal.add(vasco);
        Docente joaquim = new Docente("Joaquim", "joaquim@ccc.com", "Hardware", 4, "Efectivo");
        listFuncionariosGlobal.add(joaquim);
        NaoDocente manuel = new NaoDocente("Manuel", "manuel@la.com", "Limpeza", 4, "Efectivo");
        listFuncionariosGlobal.add(manuel);
        NaoDocente fernando = new NaoDocente("Fernando", "fernado@sim.com", "HelpDesk", 4, "Efectivo");
        listFuncionariosGlobal.add(fernando);
        NaoDocente joana = new NaoDocente("Joana", "joana@casa.pt", "Agendamento", 4, "Efectivo");
        listFuncionariosGlobal.add(joana);
        listCursosGlobal.get(0).addListDisciplina(new Disciplina("IPRP", carlos));
        listCursosGlobal.get(0).addListDisciplina(new Disciplina("POO", paulo));
        listCursosGlobal.get(0).addListDisciplina(new Disciplina("PPP", vasco));
        listCursosGlobal.get(0).getListDisciplina().get(0).addListAlunos(joao);
        listCursosGlobal.get(0).getListDisciplina().get(0).addListAlunos(pedro);
        listCursosGlobal.get(0).getListDisciplina().get(0).addListAlunos(jose);
        listCursosGlobal.get(0).getListDisciplina().get(1).addListAlunos(joao);
        listCursosGlobal.get(0).getListDisciplina().get(1).addListAlunos(miguel);
        listCursosGlobal.get(0).getListDisciplina().get(0).addListDocentes(vasco);
        listCursosGlobal.get(0).getListDisciplina().get(1).addListDocentes(joaquim);
        listSalas.add(new Sala("DEI", 1));
        listSalas.add(new Sala("DEI", 2));
        listSalas.add(new Sala("DEI", 3));
        
        
        menu(listCursosGlobal,listAlunosGlobal,listFuncionariosGlobal, listSalas);
        
    }
    /**
    * Método que apresenta o menu e reencaminha para a função pretendida.
    * para realizar a operação. 
    * 
    * @param  listCursosGlobal lista global de curos
    * @param  listAlunosGlobal lista global de alunos
    * @param  listFuncionariosGlobal lista global de funcionarios
    * @param  listSalas lista global de salas
    */
    private static void menu(ArrayList<Curso> listCursosGlobal, ArrayList<Aluno> listAlunosGlobal, ArrayList<Funcionario> listFuncionariosGlobal, ArrayList<Sala> listSalas){
        int opcao, flag=1;
        while(flag==1){
            System.out.println("----------MENU----------");
            System.out.print("99 - ADMIN\n1 - Criar Exame\n2 - Configurar Sala\n3 - Convocar vigilantes ou funcionários\n4 - Inscrever alunos\n5 - Lançar notas\n6 - Listar Exames\n7 - Listar alunos de um exame\n8 - Listar exames de um aluno\n9 - Listar associados de um exame\n10 - Listar exames de um funcionário ou docente\n11 - Listar notas de um exame\n0 - Sair\nOpção: ");
            opcao=retornaInteiro();
            switch (opcao){
                case 99:
                    setup(listCursosGlobal,listAlunosGlobal,listFuncionariosGlobal);
                    break;
                case 0:
                    flag=0;
                    break;
                case 1: 
                case 2: 
                case 3:
                case 5:
                case 9: 
                    cursoDisp(listCursosGlobal, listSalas,listFuncionariosGlobal, opcao);
                    break;
                case 4: 
                    inscreverAlunoExame(listCursosGlobal, listAlunosGlobal);
                    break;
                case 6: 
                    listarExames(listCursosGlobal);
                    break;
                case 7: 
                    listarAlunosDeExame(listCursosGlobal);
                    break;
                case 8: 
                    listarExamesDeAluno(listAlunosGlobal);
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
            guardarEmFicheiro(listCursosGlobal, listAlunosGlobal, listFuncionariosGlobal, listSalas);
            System.out.print("Clique enter para continuar");
            esperaEnter();
        }
        
    }
    /**
    * Método utilizada para escolher um curso e uma disciplina desse curso.
    * 
    * @param  listCursosGlobal lista global de curos
    * @param  listSalas lista global de salas
    * @param  listFuncionariosGlobal lista global de funcionarios
    * @param  aux variavel usada para saber qual o metodo da disciplina metodo a usar
    */
    private static void cursoDisp(ArrayList<Curso> listCursosGlobal, ArrayList<Sala> listSalas,ArrayList<Funcionario> listFuncionariosGlobal, int aux){
        ArrayList<Disciplina> listDisp;
        int opcao, sizeCursos, sizeDisp, sizeExame;
        
        sizeCursos=listCursosGlobal.size();
        if(sizeCursos==0){
            System.out.println("Não existem cursos.");
            return;
        }
        while(true){
            switch (aux) {
                case 1:
                    System.out.println("Quer adicionar um exame a que curso?: ");
                    break;
                case 2:
                    System.out.println("Quer configurar a sala de um exame de que curso?: ");
                    break;
                case 3:
                    System.out.println("Quer convocar vigilantes ou funcionarios para um exame de que curso? ");
                    break;
                case 5:
                    System.out.println("Quer lançar as notas de um exame de que curso? ");
                    break;
                case 9:
                    System.out.println("Quer ver os funcionarios associados a que exame? ");
                    break;
            }
            for (int j = 1; j <= sizeCursos; j++)
                System.out.println(j + " - " + listCursosGlobal.get(j-1).getNome());

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
            System.out.println("De que disciplina?");
            for (int j = 1; j <= sizeDisp; j++)
                System.out.println(j + " - " + listDisp.get(j-1).getNome());

            System.out.print("-> ");
            opcao=retornaInteiro();
            if(opcao>0 && opcao<sizeDisp+1) break;
            System.out.println("Opção inválida");
        }
        switch (aux) {
            case 1:
                listDisp.get(opcao-1).criaExame();
                break;
            case 2:
                if(listDisp.get(opcao-1).getListExames().isEmpty())
                    System.out.println("Não existem exames nesta disciplina!");
                else
                    listDisp.get(opcao-1).configuraSala(listSalas);
                break;
            case 3:
                if(listDisp.get(opcao-1).getListExames().isEmpty())
                    System.out.println("Não existem exames nesta disciplina!");
                else
                    listDisp.get(opcao-1).convoca(listFuncionariosGlobal);
                break;
            case 5:
                if(listDisp.get(opcao-1).getListExames().isEmpty())
                    System.out.println("Não existem exames nesta disciplina!");
                else
                    listDisp.get(opcao-1).lancaNotas();
                break;
            case 9:
                if(listDisp.get(opcao-1).getListExames().isEmpty())
                    System.out.println("Não existem exames nesta disciplina!");
                else
                    listDisp.get(opcao-1).imprimeFuncionariosExame();
                break;
        }
        
    }
    
    /**
    * Método utilizada para criar um novo curso.
    * 
    * @param  listCursosGlobal lista global de curos
    */
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
        
    /**
    * Método utilizado para criar um aluno.
    * 
    * @param  listCursosGlobal lista global de curos
    * @param listAlunosGlobal lista global de alunos
    */
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
                    System.out.print("Ano de matricula do aluno: ");
                    anoMatricula=retornaInteiro();
                    if((String.valueOf(anoMatricula).length())==4) break;
                    System.out.println("Número inválido");
                }
                
                while(true){
                    System.out.print("Regime do aluno:\n1 - Normal\n2 - Trabalhador-Estudante\n3 - Atleta\n4 - Dirigente associativo\n5 - Erasmus\n6 - Ultimo ano-> ");
                    opcao=retornaInteiro();
                    if(opcao>0 && opcao<7) break;
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
                        regime="Erasmus";
                        break;
                    case 6:
                        regime="Ultimo ano";
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
    
    /**
    * Método utilizado para criar um docentes.
    * 
    * @param  listFuncionariosGloba lista global de funcionarios
    */
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

    /**
    * Método utilizado para criar um não docente.
    * 
    * @param  listFuncionariosGloba lista global de funcionarios
    */
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
    
    /**
    * Método utilizado para adicionar disciplinas a uma curso.
    * 
    * @param  listFuncionariosGloba lista global de funcionarios
    * @param  listCursosGlobal lista global de cursos
    */
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
    
    /**
    * Método utilizado para adicionar docentes e alunos a uma disciplina .
    * 
    * @param  listFuncionariosGloba lista global de funcionarios
    * @param  listCursosGlobal lista global de cursos
    */
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

    /**
    *  Método utilizado para listar exames
    * 
    * @param  listCursosGlobal lista global de cursos
    */
    private static void listarExames(ArrayList<Curso> listCursosGlobal) {
        int i, size;
        size = listCursosGlobal.size();
        for(i=0; i<size; i++){
            System.out.println("Curso: " + listCursosGlobal.get(i).getNome());
            listCursosGlobal.get(i).imprimeExamesCurso();
        }
    }

    /**
    * . Método utilizado para listar alunos de um exame
    * 
    * @param  listCursosGlobal lista global de cursos
    */
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

    /**
    * . Método utilizado inscrever alunos em exame
    * 
    * @param  listCursosGlobal lista global de cursos
    * @param  listAlunosGlobal lista global de alunos
    */
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

    /**
    *  Método utilizado lsitar exames de um aluno.
    * 
    * @param  listCursosGlobal lista global de cursos
    * @param  listAlunosGlobal lista global de alunos
    */
    private static void listarExamesDeAluno(ArrayList<Aluno> listAlunosGlobal) {
        int i, opcao, sizeAlunos, sizeExames;
        Aluno auxAluno;
        ArrayList<Exame> listExam;
        ArrayList<Float> listNotas;
        ArrayList<Aluno> listAlunExame;
        Exame auxExame;

        sizeAlunos=listAlunosGlobal.size();
        if(sizeAlunos==0){
            System.out.println("Não existem alunos.");
            return;
        }    
        System.out.println("Escolha o aluno: ");

        for(i=0; i<sizeAlunos; i++){
            auxAluno = listAlunosGlobal.get(i);
            System.out.println("Aluno " + (i+1) + ": " + auxAluno);

        }
        System.out.print("-> ");
        while(true){
            opcao=retornaInteiro();
            if(opcao>0 && opcao<=sizeAlunos) break;
            System.out.println("Opção inválida");
        }
        
        System.out.println("Lista de exames: ");
        auxAluno=listAlunosGlobal.get(opcao-1);
        listExam=auxAluno.getInscricoes();
        
        sizeExames=listExam.size();
        for(i=0; i<sizeExames; i++){
            auxExame=listExam.get(i);
            
            System.out.println("Exame " + (i+1) + ": " + auxExame);
            listNotas=auxExame.getListNotas();
            listAlunExame=auxExame.getListAlunos();
            if(listNotas.size()==0){
                System.out.println("Notas não foram lancadas");
            }
            else{
                System.out.println("Nota: " + listNotas.get(listAlunExame.indexOf(auxAluno)));
            }
        }

    }
    
    /**
     * recebe um inteiro e certifica-se que é mesmo um inteiro.
     * 
     * @return inteiro recebido
     */
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
                System.out.print("Input inválido. Introduza um inteiro:\n->");
            }
        }
    }
    
    /**
     * recebe um float e certifica-se que é mesmo um float.
     * 
     * @return float recebido
     */
    public static float retornaFloat(){
        Scanner sc = new Scanner(System.in);
        String aux;
        float num;
        while (true) {
            aux = sc.nextLine();
            try {
                num = Float.parseFloat(aux);
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Input inválido. Introduza um float:\n->");
            }
        }
    }
    
    /**
     * recebe uma string.
     * 
     * @return string recebida
     */
    public static String retornaString(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
    /**
     * espera receber um enter
     */
    private static void esperaEnter(){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        return;
    }
    

    /**
     * guarda lsitas globais em ficheiros de objeto.
     * 
     * @param listCursosGlobal lista global de cursos
     * @param listAlunosGlobal lista global de alunos
     * @param listFuncionariosGlobal lista global de funcionarios
     * @param listSalas lista global de salas
     */
    private static void guardarEmFicheiro(ArrayList<Curso> listCursosGlobal, ArrayList<Aluno> listAlunosGlobal, ArrayList<Funcionario> listFuncionariosGlobal, ArrayList<Sala> listSalas){

        FicheiroDeObjectos fo = new FicheiroDeObjectos();
        FicheiroDeTexto ft = new FicheiroDeTexto();
        Sala auxSala;
        ArrayList<Exame> listExm;
        String fnl, auxString;
        int size;
        
        fo.abreEscrita("cursos.dat");
        fo.escreveObjecto(listCursosGlobal);
        fo.fechaEscrita();
        
        fo.abreEscrita("alunos.dat");
        fo.escreveObjecto(listAlunosGlobal);
        fo.fechaEscrita();
        
        fo.abreEscrita("funcionarios.dat");
        fo.escreveObjecto(listFuncionariosGlobal);
        fo.fechaEscrita();
        
//        ft.abreEscrita("salas.txt");
//        size=listSalas.size();
//        for(int i=0; i<size; i++){
//            System.out.println("REPEAT");
//            auxSala=listSalas.get(i);
//            listExm=auxSala.getExames();
//            auxString="";
//            for(i=0; i<listExm.size(); i++){
//                auxString+=","; //+referencia ao exame
//            }
//            fnl=auxSala.getNumero() + "-" + auxSala.getDepartamento() + "-" + auxString;
//        }
//        ft.fechaEscrita();
        
    }
    

     /**
     * lê lsitas globais de ficheiros de objeto.
     * 
     * @param listCursosGlobal lista global de cursos
     * @param listAlunosGlobal lista global de alunos
     * @param listFuncionariosGlobal lista global de funcionarios
     * @param listSalas lista global de salas
     */
    private static void carregarDeFicheiro(ArrayList<Curso> listCursosGlobal, ArrayList<Aluno> listAlunosGlobal, ArrayList<Funcionario> listFuncionariosGlobal, ArrayList<Sala> listSalas) {
        FicheiroDeObjectos fo = new FicheiroDeObjectos();
        FicheiroDeTexto ft = new FicheiroDeTexto();
        String linha;
        String delims = "[-]";
        String[] tokens;
        Sala novaSala;
        
        fo.abreLeitura("cursos.dat");
        listCursosGlobal.addAll((ArrayList<Curso>) fo.leObjecto());
        fo.fechaLeitura();
        
        fo.abreLeitura("alunos.dat");
        listAlunosGlobal.addAll((ArrayList<Aluno>) fo.leObjecto());
        fo.fechaLeitura();
        
        fo.abreLeitura("funcionarios.dat");
        listFuncionariosGlobal.addAll((ArrayList<Funcionario>) fo.leObjecto());
        fo.fechaLeitura();
        
//        ft.abreLeitura("salas.txt");
//        while((linha=ft.leLinha())!=null){
//            tokens=linha.split(delims);
//            novaSala = new Sala(tokens[1], Integer.parseInt(tokens[0]));
//            //token[2] fazer token e ir buscar varias referencias
//        }
//        ft.fechaEscrita();
                
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
