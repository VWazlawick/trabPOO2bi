package br.unipar.bancopoo.models;

public class Estado extends AbstractBaseEntity{
    private String nmEstado;
    private String sgEstado;
    private Pais pais;

    public Estado() {
    }
    
    public String getNmEstado() {
        return nmEstado;
    }

    public void setNmEstado(String nmEstado) {
        this.nmEstado = nmEstado;
    }

    public String getSgEstado() {
        return sgEstado;
    }

    public void setSgEstado(String sgEstado) {
        this.sgEstado = sgEstado;
    }
    
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Estado{" + "nmEstado=" + nmEstado + ", sgEstado=" + sgEstado + ", pais=" + pais + '}';
    }

    

    
}
