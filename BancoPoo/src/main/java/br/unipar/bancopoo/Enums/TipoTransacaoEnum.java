package br.unipar.bancopoo.Enums;

public enum TipoTransacaoEnum {
    PIX(1),
    TRANSFERENCIA(2);
    
    private int codigo;

    private TipoTransacaoEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
    
    
}
