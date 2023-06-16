package br.unipar.bancopoo.models;

import br.unipar.bancopoo.Enums.OperadoraEnum;

public class Telefone extends AbstractBaseEntity{
    private String nrTelefone;
    private OperadoraEnum operadora;
    private Pessoa pessoa;
    private Agencia agencia;

    public Telefone() {
    }

    public OperadoraEnum getOperadora() {
        return operadora;
    }

    public void setOperadora(OperadoraEnum operadora) {
        this.operadora = operadora;
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

   
    
    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    @Override
    public String toString() {
        return "Telefone{" + "nrTelefone=" + nrTelefone + ", operadora=" + operadora + ", pessoa=" + pessoa + ", agencia=" + agencia + '}';
    }

    
    
}
