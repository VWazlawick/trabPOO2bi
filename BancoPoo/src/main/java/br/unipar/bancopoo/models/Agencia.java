package br.unipar.bancopoo.models;

import java.util.ArrayList;

public class Agencia extends AbstractBaseEntity{
    private int codigo;
    private String razaoSocial;
    private String cnpj;
    private ArrayList<Telefone> telefones;
    private Banco banco;

    public Agencia() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Telefone telefone) {
        this.telefones.add(telefone);
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return "Agencia{" + "codigo=" + codigo + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", telefones=" + telefones + ", banco=" + banco + '}';
    }

   
}
