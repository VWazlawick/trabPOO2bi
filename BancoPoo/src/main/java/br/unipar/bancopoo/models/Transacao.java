package br.unipar.bancopoo.models;

public class Transacao extends AbstractBaseEntity{
    private String tipo;
    private String dhTransacao;
    private double valor;
    private Conta contaRemetente;
    private Conta contaDestinatario;

    public Transacao() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDhTransacao() {
        return dhTransacao;
    }

    public void setDhTransacao(String dhTransacao) {
        this.dhTransacao = dhTransacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Conta getContaRemetente() {
        return contaRemetente;
    }

    public void setContaRemetente(Conta contaRemetente) {
        this.contaRemetente = contaRemetente;
    }

    public Conta getContaDestinatario() {
        return contaDestinatario;
    }

    public void setContaDestinatario(Conta contaDestinatario) {
        this.contaDestinatario = contaDestinatario;
    }

    @Override
    public String toString() {
        return "Transacao{" + "tipo=" + tipo + ", dhTransacao=" + dhTransacao + ", valor=" + valor + ", contaRemetente=" + contaRemetente + ", contaDestinatario=" + contaDestinatario + '}';
    }

}
