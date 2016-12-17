package projeto;

import java.io.*;

public class FicheiroDeTexto {
    private BufferedReader fR;
    private BufferedWriter fW;
    
public boolean abreLeitura(String nomeDoFicheiro) {
        try{
            fR = new BufferedReader(new FileReader(nomeDoFicheiro));
            return true;
        } catch (IOException e){
            System.err.println("Caught IOException abreLeitura " + e.getMessage());
            return false;
        }
    } 
    
    public boolean abreEscrita(String nomeDoFicheiro) {
        try{
            fW = new BufferedWriter(new FileWriter(nomeDoFicheiro));
            return true;
        } catch (IOException e){
            System.err.println("Caught IOException abreEscrita " + e.getMessage());
            return false;
        }
    }
    
    public String leLinha() {
        try{
            return fR.readLine();
        } catch (IOException e){
            System.err.println("Caught IOException leObjecto " + e.getMessage());
            return null;
        }
    } 
    
    public void escreveLinha(String linha) {
        try{
            fW.write(linha);
            fW.newLine();
        }catch (IOException e){
            System.err.println("Caught IOException escreveObjecto " + e.getMessage());
        }
    }
    
    public void fechaLeitura() {
        try{
            fR.close();
        }catch (IOException e){
            System.err.println("Caught IOException fechaLeitura " + e.getMessage());
        }
    }
    
    public void fechaEscrita() {
        try{
            fW.close();
        }catch (IOException e){
            System.err.println("Caught IOException fechaEscrita " + e.getMessage());
        }
    }
}

