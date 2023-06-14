package br.unipar.bancopoo.services;

import br.unipar.bancopoo.exceptions.CampoNaoInformadaException;
import br.unipar.bancopoo.exceptions.CaracteresInvalidosException;
import br.unipar.bancopoo.exceptions.EntidadeInvalidoException;
import br.unipar.bancopoo.exceptions.IdInvalidoException;
import br.unipar.bancopoo.exceptions.MaximoTamanhoException;
import br.unipar.bancopoo.exceptions.NaoEncontradoException;
import br.unipar.bancopoo.models.Endereco;
import br.unipar.bancopoo.repositories.EnderecoDAO;
import java.sql.SQLException;
import java.util.List;

public class EnderecoService {

    public void validar(Endereco endereco) throws EntidadeInvalidoException, CampoNaoInformadaException, MaximoTamanhoException, CaracteresInvalidosException{
        if(endereco==null){
            throw new EntidadeInvalidoException("Endereço");
        }
        if(endereco.getRa()==null || endereco.getNmRua().isBlank() || endereco.getNmRua().isEmpty()){
            throw new CampoNaoInformadaException("RA");
        }
        if(endereco.getNmRua().length()>60){
            throw new MaximoTamanhoException("Nome da Rua", 60);
        }
        if(endereco.getNrCasa().length()>10){
            throw new MaximoTamanhoException("Número da casa", 10);
        }
        if(endereco.getCep().length()!=10){
            throw new CaracteresInvalidosException("CEP", 10);
        }
        if(endereco.getNmBairro().length()>60){
            throw new MaximoTamanhoException("Nome do Bairro", 60);
        }
        if(endereco.getDsComplemente().length()>60){
            throw new MaximoTamanhoException("Complemento", 60);
        }
        if(endereco.getRa().length()!=8){
            throw new CaracteresInvalidosException("RA", 6);
        }
    }
    public List<Endereco> findAll() throws SQLException{
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        List<Endereco> resultado = enderecoDAO.findAll();
        return resultado;
    }
    public Endereco findById(int id) throws IdInvalidoException, NaoEncontradoException, SQLException{
        if(id<=0){
            throw new IdInvalidoException("Endereço");
        }
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco retorno = enderecoDAO.findById(id);
        
        if(retorno==null){
            throw new NaoEncontradoException("Endereço");
        }
        return retorno;
    }
    public void insert(Endereco endereco) throws EntidadeInvalidoException, CampoNaoInformadaException, MaximoTamanhoException, CaracteresInvalidosException, SQLException{
        validar(endereco);
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.insert(endereco);
    }
    public void update(Endereco endereco) throws EntidadeInvalidoException, CampoNaoInformadaException, MaximoTamanhoException, CaracteresInvalidosException, SQLException{
        validar(endereco);
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.update(endereco);
    }
    public void delete(int id) throws SQLException{
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.delete(id);
    }
    

    
}
