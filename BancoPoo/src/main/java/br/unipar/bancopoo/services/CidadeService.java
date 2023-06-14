package br.unipar.bancopoo.services;
import br.unipar.bancopoo.exceptions.CampoNaoInformadaException;
import br.unipar.bancopoo.exceptions.CaracteresInvalidosException;
import br.unipar.bancopoo.exceptions.EntidadeInvalidoException;
import br.unipar.bancopoo.exceptions.IdInvalidoException;
import br.unipar.bancopoo.exceptions.MaximoTamanhoException;
import br.unipar.bancopoo.exceptions.NaoEncontradoException;
import br.unipar.bancopoo.models.Cidade;
import br.unipar.bancopoo.repositories.CidadeDAO;
import br.unipar.bancopoo.repositories.EstadoDAO;
import java.sql.SQLException;
import java.util.List;
        
public class CidadeService {

    public void validar(Cidade cidade) throws EntidadeInvalidoException, CampoNaoInformadaException, MaximoTamanhoException, CaracteresInvalidosException{
        if(cidade==null){
            throw new EntidadeInvalidoException("Cidade");
        }
        if(cidade.getNmCidade()==null || cidade.getNmCidade().isBlank() || cidade.getNmCidade().isEmpty()){
            throw new CampoNaoInformadaException("Nome da Cidade");
        }
        if(cidade.getNmCidade().length()>60){
            throw new MaximoTamanhoException("Nome da Cidade", 60);
        }
        if(cidade.getEstado()==null){
            throw new EntidadeInvalidoException("Estado");
        }
        if(cidade.getRa().length()!=8){
            throw new CaracteresInvalidosException("RA", 8);
        }
    }
    public List<Cidade> findAll() throws SQLException{
        CidadeDAO cidadeDAO = new CidadeDAO();
        List<Cidade> retorno = cidadeDAO.findAll();
        return retorno;        
    }
    public Cidade findById(int id) throws IdInvalidoException, NaoEncontradoException, SQLException{
        if(id<=0){
            throw new IdInvalidoException("Cidade");
        }
        CidadeDAO cidadeDAO = new CidadeDAO();
        Cidade retorno = cidadeDAO.findById(id);
        if(retorno==null){
            throw new NaoEncontradoException("Cidade");
        }
        return retorno;
    }
    public void insert(Cidade cidade) throws EntidadeInvalidoException, CampoNaoInformadaException, MaximoTamanhoException, CaracteresInvalidosException, SQLException{
        validar(cidade);
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.insert(cidade);
    }
    public void update(Cidade cidade) throws EntidadeInvalidoException, CampoNaoInformadaException, MaximoTamanhoException, CaracteresInvalidosException, SQLException{
        validar(cidade);
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.update(cidade);
    }
    public void delete(int id) throws SQLException{
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.delete(id);
    }
    
}
