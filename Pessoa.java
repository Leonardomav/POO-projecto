package projeto;

import java.io.Serializable;

public abstract class Pessoa implements Serializable{
    private String nome;
    private String email;

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
    
    
    
    
}
