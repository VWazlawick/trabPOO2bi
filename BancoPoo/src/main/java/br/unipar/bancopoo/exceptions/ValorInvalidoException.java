package br.unipar.bancopoo.exceptions;

public class ValorInvalidoException extends Exception{
    public ValorInvalidoException(String campo){
        super("Valor inválido para " + campo);
    }
}
