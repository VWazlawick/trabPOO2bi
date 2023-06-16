package br.unipar.bancopoo.services;

import br.unipar.bancopoo.exceptions.CampoNaoInformadaException;
import br.unipar.bancopoo.exceptions.CaracteresInvalidosException;
import br.unipar.bancopoo.exceptions.EntidadeInvalidoException;
import br.unipar.bancopoo.exceptions.IdInvalidoException;
import br.unipar.bancopoo.exceptions.MaximoTamanhoException;
import br.unipar.bancopoo.exceptions.NaoEncontradoException;
import br.unipar.bancopoo.models.Telefone;
import br.unipar.bancopoo.repositories.TelefoneDAO;
import java.sql.SQLException;
import java.util.List;

public class TelefoneService {

    public void validar(Telefone telefone)throws SQLException, EntidadeInvalidoException, CampoNaoInformadaException, MaximoTamanhoException, CaracteresInvalidosException{
        if(telefone==null){
            throw new EntidadeInvalidoException("Telefone");
        }
        if(telefone.getNrTelefone()==null || telefone.getNrTelefone().isBlank() || telefone.getNrTelefone().isEmpty()){
            throw new CampoNaoInformadaException("Número de Telefone");
        }
        if(telefone.getNrTelefone().length()>14){
            throw new MaximoTamanhoException("Número de Telefone", 14);
        }
        if(telefone.getRa().length()!=8){
            throw new CaracteresInvalidosException("RA", 8);
        }
        if(telefone.getPessoa()==null && telefone.getAgencia()==null){
            throw new CampoNaoInformadaException("Pessoa/Agencia");
        }
        if(telefone.getOperadora()==null){
            throw new CampoNaoInformadaException("Operadora");
        }
    }
    public List findAll() throws SQLException{
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        List<Telefone> retorno = telefoneDAO.findAll();
        return retorno;
    }
    public Telefone findById(int id) throws SQLException, IdInvalidoException, NaoEncontradoException{
        if(id<=0){
            throw new IdInvalidoException("Telefone");
        }
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        Telefone retorno = telefoneDAO.findById(id);
        
        if(retorno==null){
            throw new NaoEncontradoException("Telefone");
        }
        return retorno;
    }
    public void insert(Telefone telefone)throws SQLException, EntidadeInvalidoException, CampoNaoInformadaException, MaximoTamanhoException, CaracteresInvalidosException{
        validar(telefone);
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.insert(telefone);
    }
    public void update(Telefone telefone)throws SQLException, EntidadeInvalidoException, CampoNaoInformadaException, MaximoTamanhoException, CaracteresInvalidosException{
        validar(telefone);
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.update(telefone);
    }
    public void delete(int id)throws SQLException{
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.delete(id);
    }
}
