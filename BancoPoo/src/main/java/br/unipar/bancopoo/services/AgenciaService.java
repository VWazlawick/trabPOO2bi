package br.unipar.bancopoo.services;

import br.unipar.bancopoo.exceptions.CampoNaoInformadaException;
import br.unipar.bancopoo.exceptions.CaracteresInvalidosException;
import br.unipar.bancopoo.exceptions.EntidadeInvalidoException;
import br.unipar.bancopoo.exceptions.IdInvalidoException;
import br.unipar.bancopoo.exceptions.MaximoTamanhoException;
import br.unipar.bancopoo.exceptions.NaoEncontradoException;
import br.unipar.bancopoo.models.Agencia;
import br.unipar.bancopoo.repositories.AgenciaDAO;
import java.sql.SQLException;
import java.util.List;

public class AgenciaService {
    public void validar(Agencia agencia) throws CampoNaoInformadaException, IdInvalidoException, EntidadeInvalidoException, MaximoTamanhoException, CaracteresInvalidosException{
        if(agencia==null){
            throw new EntidadeInvalidoException("Agencia");
        }
        if(agencia.getId()<=0){
            throw new IdInvalidoException("ID");
        }
        if(agencia.getCodigo()==null || agencia.getCodigo().isBlank() || agencia.getCodigo().isEmpty()){
            throw new CampoNaoInformadaException("Código");
        }
        if(agencia.getDigito()==null || agencia.getDigito().isBlank() || agencia.getDigito().isEmpty()){
            throw new CampoNaoInformadaException("Digito");
        }
        if(agencia.getRazaoSocial()==null || agencia.getRazaoSocial().isBlank() || agencia.getRazaoSocial().isEmpty()){
            throw new CampoNaoInformadaException("Razão Social");
        }
        if(agencia.getCodigo().length()>10){
            throw new MaximoTamanhoException("Código", 10);
        }
        if(agencia.getDigito().length()>2){
            throw new MaximoTamanhoException("Digito", 2);
        }
        if(agencia.getRazaoSocial().length()>60){
            throw new MaximoTamanhoException("Razão Social", 60);
        }
        if(agencia.getCnpj().length()>18){
            throw new MaximoTamanhoException("CNPJ", 18);
        }
        if(agencia.getRa().length()!=8){
            throw new CaracteresInvalidosException("RA", 8);
        }
        if(agencia.getBanco()==null){
            throw new CampoNaoInformadaException("Banco");
        }
    }
    public List findAll() throws SQLException{
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        List<Agencia> retorno = agenciaDAO.findAll();
        return retorno;
    }
    public Agencia findById(int id) throws SQLException, IdInvalidoException, NaoEncontradoException{
        if(id<=0){
            throw new IdInvalidoException("Agencia");
        }
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        Agencia retorno = agenciaDAO.findById(id);
        
        if(retorno==null){
            throw new NaoEncontradoException("Agencia");
        }
        return retorno;
    }
    public void insert(Agencia agencia) throws SQLException, CampoNaoInformadaException, IdInvalidoException, EntidadeInvalidoException, MaximoTamanhoException, CaracteresInvalidosException{
        validar(agencia);
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.insert(agencia);
    }
    public void update(Agencia agencia) throws SQLException, CampoNaoInformadaException, IdInvalidoException, EntidadeInvalidoException, MaximoTamanhoException, CaracteresInvalidosException{
        validar(agencia);
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.update(agencia);
    }
    public void delete(int id) throws SQLException{
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.delete(id);
    }
}
