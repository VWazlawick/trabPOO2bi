package br.unipar.bancopoo.Enums;

public enum TipoContaEnum {
    CONTA_CORRENTE("1"),
    POUPANCA("2"),
    SALARIO("3");
    
    private String codigo;

    private TipoContaEnum(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
    
    
}
