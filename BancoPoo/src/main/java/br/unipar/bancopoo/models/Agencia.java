package br.unipar.bancopoo.models;

import java.util.ArrayList;

public class Agencia extends AbstractBaseEntity{
    private String codigo;
    private String digito;
    private String razaoSocial;
    private String cnpj;
    private Banco banco;

    public Agencia() {
    }

    public String getCodigo() {
        return codigo;
    }

    public Agencia(String codigo, String digito, String razaoSocial, String cnpj, Banco banco) {
        this.codigo = codigo;
        this.digito = digito;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.banco = banco;
    }

    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return "Agencia{" + "codigo=" + codigo + ", digito=" + digito + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", banco=" + banco + '}';
    }

    

   
}
