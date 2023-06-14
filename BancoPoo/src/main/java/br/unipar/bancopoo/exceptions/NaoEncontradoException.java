package br.unipar.bancopoo.exceptions;

public class NaoEncontradoException extends Exception {
    public NaoEncontradoException(String entidade){
        super(entidade + " não encontrada");
    }
}
