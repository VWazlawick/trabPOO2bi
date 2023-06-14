package br.unipar.bancopoo.models;

public class Conta extends AbstractBaseEntity{
    private String nrConta;
    private String agencia;
    private int digito;
    private String tipo;
    private double saldo;
    private Banco banco;
    private Pessoa pessoa;

    public Conta() {
    }

    public String getNrConta() {
        return nrConta;
    }

    public void setNrConta(String nrConta) {
        this.nrConta = nrConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Conta{" + "nrConta=" + nrConta + ", agencia=" + agencia + ", digito=" + digito + ", tipo=" + tipo + ", saldo=" + saldo + ", banco=" + banco + ", pessoa=" + pessoa + '}';
    }

    
    
    
}
