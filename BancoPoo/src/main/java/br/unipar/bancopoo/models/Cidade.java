package br.unipar.bancopoo.models;

public class Cidade extends AbstractBaseEntity{
    private String nmCidade;
    private Estado estado;

    public Cidade() {
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cidade{" + "nmCidade=" + nmCidade + ", estado=" + estado + '}';
    }

    
    
}
