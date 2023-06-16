package br.unipar.bancopoo.models;

import br.unipar.bancopoo.Enums.TipoTransacaoEnum;
import java.sql.Date;


public class Transacao extends AbstractBaseEntity{

    private Date dhTransacao;
    private double valor;
    private TipoTransacaoEnum tipo;
    private Conta contaOrigem;
    private Conta contaDestino;

    public Transacao() {
    }

    public TipoTransacaoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacaoEnum tipo) {
        this.tipo = tipo;
    }
    
    public Date getDhTransacao() {
        return dhTransacao;
    }

    public void setDhTransacao(Date dhTransacao) {
        this.dhTransacao = dhTransacao;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    @Override
    public String toString() {
        return "Transacao{" + "dhTransacao=" + dhTransacao + ", valor=" + valor + ", tipo=" + tipo + ", contaOrigem=" + contaOrigem + ", contaDestino=" + contaDestino + '}';
    }
    
    
}
