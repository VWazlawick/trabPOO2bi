package br.unipar.bancopoo.exceptions;

public class CampoNaoInformadaException extends Exception{
    
    public CampoNaoInformadaException(String entidade){
        super(entidade + " Não informada(o) e deve ser preenchida(o)."
                + "Verifique!!");
    }
}
