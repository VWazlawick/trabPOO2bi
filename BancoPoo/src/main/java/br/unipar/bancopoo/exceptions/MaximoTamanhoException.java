package br.unipar.bancopoo.exceptions;

public class MaximoTamanhoException extends Exception{
    
    public MaximoTamanhoException(String entidade, int caract){
        super("Informe o máximo de " + caract + " caracteres para " + entidade);
    }
}
