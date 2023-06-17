package br.unipar.bancopoo.models;

import java.sql.Date;
import java.util.ArrayList;

public class PessoaFisica extends Pessoa{
    private String nmPessoa;
    private String cpf;
    private String rg;
    private Date dtnasc;

    public PessoaFisica() {
    }
    
    public String getNmPessoa() {
        return nmPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(Date dtnasc) {
        this.dtnasc = dtnasc;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" + "nmPessoa=" + nmPessoa + ", cpf=" + cpf + ", rg=" + rg + ", dtnasc=" + dtnasc + '}';
    }

    
    
    
}
