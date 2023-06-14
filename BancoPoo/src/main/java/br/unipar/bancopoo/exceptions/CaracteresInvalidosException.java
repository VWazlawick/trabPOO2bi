package br.unipar.bancopoo.exceptions;

public class CaracteresInvalidosException extends Exception{
    
    public CaracteresInvalidosException(String entidade, int caract){
        super("Informe " + caract + " caracteres para " + entidade);
    }
}
