package br.unipar.bancopoo.services;

import br.unipar.bancopoo.exceptions.CampoNaoInformadaException;
import br.unipar.bancopoo.exceptions.CaracteresInvalidosException;
import br.unipar.bancopoo.exceptions.EntidadeInvalidoException;
import br.unipar.bancopoo.exceptions.IdInvalidoException;
import br.unipar.bancopoo.exceptions.MaximoTamanhoException;
import br.unipar.bancopoo.exceptions.NaoEncontradoException;
import br.unipar.bancopoo.models.PessoaFisica;
import br.unipar.bancopoo.repositories.PessoaFisicaDAO;
import java.sql.SQLException;
import java.util.List;

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
        if(pessoaFisica.getCpf().length()>14){
            throw new CaracteresInvalidosException("CPF", 14);
        }
        if(pessoaFisica.getDtnasc()==null){
            throw new CampoNaoInformadaException("Data de Nacimento");
        }
        if(pessoaFisica.getRg().length()>12){
            throw new CaracteresInvalidosException("RG", 12);
        }
        if(pessoaFisica.getEmail().length()>60){
            throw new MaximoTamanhoException("Email", 60);
        }
    }
    public List<PessoaFisica> findAll()throws SQLException{
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        List<PessoaFisica> retorno = pessoaFisicaDAO.findAll();
        return retorno;
    }
    public PessoaFisica findById(int id) throws SQLException, IdInvalidoException, NaoEncontradoException{
        if(id<=0){
            throw new IdInvalidoException("Pessoa Fisica");
        }
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisica retorno = pessoaFisicaDAO.findById(id);
        
        if(retorno == null){
            throw new NaoEncontradoException("Pessoa Fisica");
        }
        return retorno;
    }
    public void insert(PessoaFisica pessoaFisica) throws EntidadeInvalidoException, SQLException, CampoNaoInformadaException, MaximoTamanhoException, CaracteresInvalidosException{
        validar(pessoaFisica);
        PessoaService ps = new PessoaService();
        ps.insert(pessoaFisica);
        
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.insert(pessoaFisica);
    }
    public void update(PessoaFisica pessoaFisica)throws SQLException, EntidadeInvalidoException, CampoNaoInformadaException, MaximoTamanhoException, CaracteresInvalidosException{
        validar(pessoaFisica);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.update(pessoaFisica);
    }
    public void delete(int id) throws SQLException{
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.delete(id);
    }
}
