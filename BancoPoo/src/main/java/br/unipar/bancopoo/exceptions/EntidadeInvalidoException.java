package br.unipar.bancopoo.exceptions;

public class EntidadeInvalidoException extends Exception{
    
    public EntidadeInvalidoException(String entidade){
        super("Informe o(a) " + entidade);
    }
}
