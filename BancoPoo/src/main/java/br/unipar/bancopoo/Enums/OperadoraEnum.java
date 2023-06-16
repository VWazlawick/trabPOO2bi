package br.unipar.bancopoo.Enums;

public enum OperadoraEnum {
    TIM (41),
    VIVO(15),
    CLARO(21),
    OI(31);
    
    int codigo;

    private OperadoraEnum(int codigo) {
        this.codigo = codigo;
    }
        
    public int getCodigo() {
        return codigo;
    }
    
    
}
