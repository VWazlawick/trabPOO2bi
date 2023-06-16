package br.unipar.bancopoo.models;

import br.unipar.bancopoo.Enums.TipoContaEnum;

public class Conta extends AbstractBaseEntity{
    private String nrConta;
    private String digito;
    private TipoContaEnum tipo;
    private double saldo;
    private Agencia agencia;
    private Pessoa pessoa;

    public Conta() {
    }

    public Conta(String nrConta, String digito, TipoContaEnum tipo, double saldo, Agencia agencia, Pessoa pessoa) {
        this.nrConta = nrConta;
        this.digito = digito;
        this.tipo = tipo;
        this.saldo = saldo;
        this.agencia = agencia;
        this.pessoa = pessoa;
    }

    public String getNrConta() {
        return nrConta;
    }

    public void setNrConta(String nrConta) {
        this.nrConta = nrConta;
    }
    
    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public TipoContaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoContaEnum tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }   

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "Conta{" + "nrConta=" + nrConta + ", digito=" + digito + ", tipo=" + tipo + ", saldo=" + saldo + ", agencia=" + agencia + ", pessoa=" + pessoa + '}';
    }

    

    
    
    
}
