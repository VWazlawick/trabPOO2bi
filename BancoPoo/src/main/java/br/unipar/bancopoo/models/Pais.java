package br.unipar.bancopoo.models;

public class Pais extends AbstractBaseEntity{
    private String nmPais;
    private String sgPais;

    public Pais() {
    }

    public String getNmPais() {
        return nmPais;
    }

    public void setNmPais(String nmPais) {
        this.nmPais = nmPais;
    }

    public String getSgPais() {
        return sgPais;
    }

    public void setSgPais(String sgPais) {
        this.sgPais = sgPais;
    }

    @Override
    public String toString() {
        return "Pais{" + "nmPais=" + nmPais + ", sgPais=" + sgPais + '}';
    }

        
}
