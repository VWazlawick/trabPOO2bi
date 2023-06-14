package br.unipar.bancopoo.services;

import br.unipar.bancopoo.exceptions.CampoNaoInformadaException;
import br.unipar.bancopoo.exceptions.CaracteresInvalidosException;
import br.unipar.bancopoo.exceptions.EntidadeInvalidoException;
import br.unipar.bancopoo.exceptions.MaximoTamanhoException;
import br.unipar.bancopoo.models.PessoaFisica;

public class PessoaFisicaService {

    public void validar(PessoaFisica pessoaFisica) throws EntidadeInvalidoException, CampoNaoInformadaException, MaximoTamanhoException, CaracteresInvalidosException{
        if(pessoaFisica==null){
            throw new EntidadeInvalidoException("Pessoa Fisica");
        }
        if(pessoaFisica.getNmPessoa()==null || pessoaFisica.getNmPessoa().isBlank() || pessoaFisica.getNmPessoa().isEmpty()){
            throw new CampoNaoInformadaException("Nome da Pessoa");
        }
        if(pessoaFisica.getCpf()==null || pessoaFisica.getCpf().isBlank() || pessoaFisica.getCpf().isEmpty()){
            throw new CampoNaoInformadaException("CPF");
        }
        if(pessoaFisica.getRa()==null || pessoaFisica.getRa().isBlank() || pessoaFisica.getRa().isEmpty()){
            throw new CampoNaoInformadaException("RA");
        }
        if(pessoaFisica.getNmPessoa().length()>60){
            throw new MaximoTamanhoException("Nome da Pessoa", 60);
        }
        if(pessoaFisica.getCpf().length()==14){
            throw new CaracteresInvalidosException("CPF", 14);
        }
        if(pessoaFisica.getDtnasc().length()==10){
            throw new CaracteresInvalidosException("Data de Nascimento", 10);
        }
        if(pessoaFisica.getRg().length()==12){
            throw new CaracteresInvalidosException("RG", 12);
        }
        if(pessoaFisica.getEmail().length()>60){
            throw new MaximoTamanhoException("Email", 60);
        }
    }
}
