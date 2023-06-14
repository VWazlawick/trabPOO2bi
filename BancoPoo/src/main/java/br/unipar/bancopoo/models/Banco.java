package br.unipar.bancopoo.models;

public class Banco extends AbstractBaseEntity{
    private String nmBanco;

    public Banco() {
    }
    
    public String getNmBanco() {
        return nmBanco;
    }

    public void setNmBanco(String nmBanco) {
        this.nmBanco = nmBanco;
    }

    @Override
    public String toString() {
        return "Banco{" + "nmBanco=" + nmBanco + '}';
    }


   

    
    
}
