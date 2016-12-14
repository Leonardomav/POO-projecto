package projeto;

import java.io.*;

public class FicheiroDeObjectos {
    private ObjectInputStream iS;
    private ObjectOutputStream oS;
    
    public boolean abreLeitura(String nomeDoFicheiro) {
        try{
            iS = new ObjectInputStream(new FileInputStream(nomeDoFicheiro));
            return true;
        } catch (IOException e){
            System.err.println("Caught IOException abreLeitura " + e.getMessage());
            return false;
        }
    } 
    
    public boolean abreEscrita(String nomeDoFicheiro) {
        try{
            oS = new ObjectOutputStream(new FileOutputStream(nomeDoFicheiro));
            return true;
        } catch (IOException e){
            System.err.println("Caught IOException abreEscrita " + e.getMessage());
            return false;
        }
    }
    
    public Object leObjecto() {
        try{
            return iS.readObject();
        } catch (IOException e){
            System.err.println("Caught IOException leObjecto " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e){
            System.err.println("Caught ClassNotFoundException leObjecto " + e.getMessage());
            return null;
        }
    } 
    
    public void escreveObjecto(Object o) {
        try{
            oS.writeObject(o);
        }catch (IOException e){
            System.err.println("Caught IOException escreveObjecto " + e.getMessage());
        }
    }
    
    public void fechaLeitura() {
        try{
            iS.close();
        }catch (IOException e){
            System.err.println("Caught IOException fechaLeitura " + e.getMessage());
        }
    }
    
    public void fechaEscrita() {
        try{
            oS.close();
        }catch (IOException e){
            System.err.println("Caught IOException fechaEscrita " + e.getMessage());
        }
    }
}
