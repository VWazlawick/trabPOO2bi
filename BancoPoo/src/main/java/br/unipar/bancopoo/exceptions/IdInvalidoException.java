package br.unipar.bancopoo.exceptions;

public class IdInvalidoException extends Exception {
    public IdInvalidoException(String entidade){
        super("O Id buscado para " + entidade + " é inválido");
    }
}
