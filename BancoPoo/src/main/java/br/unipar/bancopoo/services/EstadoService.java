package br.unipar.bancopoo.services;

import br.unipar.bancopoo.exceptions.CampoNaoInformadaException;
import br.unipar.bancopoo.exceptions.CaracteresInvalidosException;
import br.unipar.bancopoo.exceptions.EntidadeInvalidoException;
import br.unipar.bancopoo.exceptions.IdInvalidoException;
import br.unipar.bancopoo.exceptions.MaximoTamanhoException;
import br.unipar.bancopoo.exceptions.NaoEncontradoException;
import br.unipar.bancopoo.models.Estado;
import br.unipar.bancopoo.repositories.EstadoDAO;
import java.sql.SQLException;
import java.util.List;

public class EstadoService {

    public void validar(Estado estado) throws EntidadeInvalidoException, CampoNaoInformadaException, CaracteresInvalidosException, MaximoTamanhoException{
       if(estado==null){
           throw new EntidadeInvalidoException("Estado");           
       }
       if(estado.getNmEstado()==null || estado.getNmEstado().isEmpty() || estado.getNmEstado().isBlank()){
           throw new CampoNaoInformadaException("Nome do Estado");
       }
       if(estado.getSgEstado()==null || estado.getSgEstado().isBlank() || estado.getSgEstado().isEmpty()){
           throw new CampoNaoInformadaException("Sigla do Estado");
       }
       if(estado.getSgEstado().length()!=2){
           throw new CaracteresInvalidosException("Sigla do Estado", 2);
       }
       if(estado.getNmEstado().length()>24){
           throw new MaximoTamanhoException("Nome do Estado", 24);
       }
       if(estado.getPais()==null){
           throw new EntidadeInvalidoException("Pais");
       }
       if(estado.getRa().length()!=8){
            throw new CaracteresInvalidosException("RA", 8);
        }
    }
    public List<Estado> findAll() throws SQLException{
        EstadoDAO estadoDAO = new EstadoDAO();
        List<Estado> resultado = estadoDAO.findAll();
        
        return resultado;
    }
    
    public Estado findById(int id) throws IdInvalidoException, NaoEncontradoException, SQLException{
        if(id<=0){
            throw new IdInvalidoException("Estado");
        }
        EstadoDAO estadoDAO = new EstadoDAO();
        
        Estado retorno = estadoDAO.findById(id);
        
        if(retorno==null){
            throw new NaoEncontradoException("Estado");
        }
        
        return retorno;
    }
    
    public void insert(Estado estado) throws SQLException, EntidadeInvalidoException, CampoNaoInformadaException, CaracteresInvalidosException, MaximoTamanhoException{
        validar(estado);
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.insert(estado);
    }
    
    public void update(Estado estado) throws SQLException, CampoNaoInformadaException, EntidadeInvalidoException, CaracteresInvalidosException, MaximoTamanhoException{
        validar(estado);
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.update(estado);
    }
    
    public void delete(int id) throws SQLException{
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.delete(id);
    }
    
}
