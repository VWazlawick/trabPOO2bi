package br.unipar.bancopoo.Enums;

public enum TipoContaEnum {
    CONTA_CORRENTE(1),
    POUPANCA(2),
    SALARIO(3);
    
    private int codigo;

    private TipoContaEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
    
    
}
