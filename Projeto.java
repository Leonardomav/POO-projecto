package projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class Projeto {

    public static void main(String[] args) {
        ArrayList<Curso> listCursos;
        
        menu();
    }
    
    public static void menu(){
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
                
        }
        
        
    }
    
    public void criaCurso(){
        
    }
    
    public void criaSala(){
        
    }
    
    public void criaAluno(){
        
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

}
