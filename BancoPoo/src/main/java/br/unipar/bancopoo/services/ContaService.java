package br.unipar.bancopoo.services;

import br.unipar.bancopoo.exceptions.CampoNaoInformadaException;
import br.unipar.bancopoo.exceptions.CaracteresInvalidosException;
import br.unipar.bancopoo.exceptions.EntidadeInvalidoException;
import br.unipar.bancopoo.exceptions.IdInvalidoException;
import br.unipar.bancopoo.exceptions.MaximoTamanhoException;
import br.unipar.bancopoo.exceptions.NaoEncontradoException;
import br.unipar.bancopoo.models.Conta;
import br.unipar.bancopoo.repositories.ContaDAO;
import java.sql.SQLException;
import java.util.List;

public class ContaService {
    
    public void validar(Conta conta) throws CampoNaoInformadaException, EntidadeInvalidoException, MaximoTamanhoException, CaracteresInvalidosException{
        if(conta==null){
            throw new EntidadeInvalidoException("Conta");
        }
        if(conta.getNrConta()==null || conta.getNrConta().isBlank() || conta.getNrConta().isEmpty()){
            throw new CampoNaoInformadaException("Número da Conta");
        }
        if(conta.getDigito()==null || conta.getNrConta().isBlank() || conta.getNrConta().isEmpty()){
            throw new CampoNaoInformadaException("Digito");
        }
        if(conta.getNrConta().length()>10){
            throw new MaximoTamanhoException("Número da Conta", 10);
        }
        if(conta.getDigito().length()>2){
            throw new MaximoTamanhoException("Digito", 2);
        }
        if(conta.getRa().length()!=8){
            throw new CaracteresInvalidosException("RA", 8);
        }
    }
    public List findAll() throws SQLException{
        ContaDAO contaDAO = new ContaDAO();
        List<Conta> retorno = contaDAO.findAll();
        return retorno;
    }
    public Conta findById(int id)throws SQLException, IdInvalidoException, NaoEncontradoException{
        if(id<=0){
            throw new IdInvalidoException("Conta");
        }
        ContaDAO contaDAO = new ContaDAO();
        Conta retorno = contaDAO.findById(id);
        if(retorno==null){
            throw new NaoEncontradoException("Conta");
        }
        return retorno;
    }
    public void insert(Conta conta)throws SQLException, CampoNaoInformadaException, EntidadeInvalidoException, MaximoTamanhoException, CaracteresInvalidosException{
        validar(conta);
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.insert(conta);
    }
    public void update(Conta conta)throws SQLException, CampoNaoInformadaException, EntidadeInvalidoException, MaximoTamanhoException, CaracteresInvalidosException{
        validar(conta);
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.update(conta);
    }    
    public void delete(int id) throws SQLException{
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.delete(id);
    }
}
