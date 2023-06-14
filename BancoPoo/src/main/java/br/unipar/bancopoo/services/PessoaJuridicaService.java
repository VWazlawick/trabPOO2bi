package br.unipar.bancopoo.services;

import br.unipar.bancopoo.exceptions.CampoNaoInformadaException;
import br.unipar.bancopoo.exceptions.CaracteresInvalidosException;
import br.unipar.bancopoo.exceptions.EntidadeInvalidoException;
import br.unipar.bancopoo.exceptions.MaximoTamanhoException;
import br.unipar.bancopoo.models.PessoaJuridica;

public class PessoaJuridicaService {

    public void validar(PessoaJuridica pessoaJuridica) throws EntidadeInvalidoException, CampoNaoInformadaException, CaracteresInvalidosException, MaximoTamanhoException{
        if(pessoaJuridica==null){
            throw new EntidadeInvalidoException("Pessoa Juridíca");
        }
        if(pessoaJuridica.getCnaePrincipal()==null || pessoaJuridica.getCnaePrincipal().isBlank() || pessoaJuridica.getCnaePrincipal().isEmpty()){
            throw new CampoNaoInformadaException("CNAE");
        }
        if(pessoaJuridica.getCnpj()==null || pessoaJuridica.getCnpj().isBlank() || pessoaJuridica.getCnpj().isEmpty()){
            throw new CampoNaoInformadaException("CNPJ");
        }
        if(pessoaJuridica.getFantasia()==null || pessoaJuridica.getFantasia().isBlank() || pessoaJuridica.getFantasia().isEmpty()){
            throw new CampoNaoInformadaException("Nome Fantasia");
        }
        if(pessoaJuridica.getRa()==null || pessoaJuridica.getRa().isBlank() || pessoaJuridica.getRa().isEmpty()){
            throw new CampoNaoInformadaException("RA");
        }
        if(pessoaJuridica.getRazaoSocial()==null || pessoaJuridica.getRazaoSocial().isBlank() || pessoaJuridica.getRazaoSocial().isEmpty()){
            throw new CampoNaoInformadaException("Nome Razão Social");
        }
        if(pessoaJuridica.getCnaePrincipal().length()==7){
            throw new CaracteresInvalidosException("CNAE", 7);
        }
        if(pessoaJuridica.getCnpj().length()==18){
            throw new CaracteresInvalidosException("CNPJ", 18);
        }
        if(pessoaJuridica.getEmail().length()>60){
            throw new MaximoTamanhoException("Email", 60);
        }
        if(pessoaJuridica.getFantasia().length()>128){
            throw new MaximoTamanhoException("Nome Fantasia", 128);
        }
        if(pessoaJuridica.getRa().length()==8){
            throw new CaracteresInvalidosException("RA", 8);
        }
        if(pessoaJuridica.getRazaoSocial().length()>128){
            throw new MaximoTamanhoException("Razão Social", 128);
        }
    }
}
