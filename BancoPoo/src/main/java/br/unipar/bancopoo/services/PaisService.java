package br.unipar.bancopoo.services;

import br.unipar.bancopoo.exceptions.CaracteresInvalidosException;
import br.unipar.bancopoo.exceptions.EntidadeInvalidoException;
import br.unipar.bancopoo.exceptions.CampoNaoInformadaException;
import br.unipar.bancopoo.exceptions.IdInvalidoException;
import br.unipar.bancopoo.exceptions.MaximoTamanhoException;
import br.unipar.bancopoo.exceptions.NaoEncontradoException;
import br.unipar.bancopoo.models.Pais;
import br.unipar.bancopoo.repositories.PaisDAO;
import java.sql.SQLException;
import java.util.List;

public class PaisService {

    public void validar(Pais pais) throws CampoNaoInformadaException, EntidadeInvalidoException, CaracteresInvalidosException, MaximoTamanhoException, IdInvalidoException{
        if(pais==null){
            throw new CampoNaoInformadaException("Pais");
        }
        if(pais.getNmPais()==null || pais.getNmPais().isEmpty()|| pais.getNmPais().isBlank()){
            throw new EntidadeInvalidoException("Nome do País");
        }
        if(pais.getSgPais()==null || pais.getSgPais().isEmpty() || pais.getSgPais().isBlank()){
            throw new EntidadeInvalidoException("Sigla do Pais");
        }
        if(!(pais.getSgPais().length() == 2)){
            throw new CaracteresInvalidosException("Sigla do Pais",2);
        }
        if(pais.getNmPais().length()>60){
            throw new MaximoTamanhoException("Nome do País", 60);
        }
        if(pais.getRa().length()!=8){
            throw new CaracteresInvalidosException("RA", 8);
        }
        if(pais.getId()<=0){
            throw new CampoNaoInformadaException("ID");
        }
    }
    public List<Pais> findAll() throws SQLException{
        PaisDAO paisDAO = new PaisDAO();
        List<Pais> resultado = paisDAO.findAll();
        
        return resultado;
    }
    public Pais findById(int id) throws SQLException, Exception{
        if(id<=0){
            throw new IdInvalidoException("Páis");
        }
        
        PaisDAO paisDAO = new PaisDAO();
        
       Pais retorno =  paisDAO.findById(id);
       
       if(retorno==null){
           throw new NaoEncontradoException("Páis");
       }
       return retorno;
    }
    public void insert(Pais pais) throws SQLException, CampoNaoInformadaException, EntidadeInvalidoException,CaracteresInvalidosException, MaximoTamanhoException, IdInvalidoException{
        validar(pais);
        PaisDAO paisDAO = new PaisDAO();
        paisDAO.insert(pais);
    }
    public void update(Pais pais) throws SQLException, CampoNaoInformadaException,EntidadeInvalidoException, CaracteresInvalidosException, MaximoTamanhoException, IdInvalidoException{
        validar(pais);
        PaisDAO paisDAO = new PaisDAO();
        paisDAO.update(pais);
    }
    public void delete(int id) throws SQLException{
        PaisDAO paisDao = new PaisDAO();
        paisDao.delete(id);
    }
    
}
