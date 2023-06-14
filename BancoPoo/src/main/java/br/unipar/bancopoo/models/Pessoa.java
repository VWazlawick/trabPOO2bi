package br.unipar.bancopoo.models;

import java.util.ArrayList;

public abstract class Pessoa extends AbstractBaseEntity{
    private String email;

    public Pessoa() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "email=" + email + '}';
    }

    

    
}
