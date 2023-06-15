package br.unipar.bancopoo.services;

import br.unipar.bancopoo.exceptions.CampoNaoInformadaException;
import br.unipar.bancopoo.exceptions.CaracteresInvalidosException;
import br.unipar.bancopoo.exceptions.EntidadeInvalidoException;
import br.unipar.bancopoo.exceptions.IdInvalidoException;
import br.unipar.bancopoo.exceptions.MaximoTamanhoException;
import br.unipar.bancopoo.exceptions.NaoEncontradoException;
import br.unipar.bancopoo.models.Banco;
import br.unipar.bancopoo.repositories.BancoDAO;
import java.sql.SQLException;
import java.util.List;

public class BancoService {

    public void validar(Banco banco)throws SQLException, EntidadeInvalidoException, CampoNaoInformadaException, MaximoTamanhoException, CaracteresInvalidosException{
        if(banco==null){
            throw new EntidadeInvalidoException("Banco");
        }
        if(banco.getNmBanco()==null || banco.getNmBanco().isBlank() || banco.getNmBanco().isEmpty()){
            throw new CampoNaoInformadaException("Nome do Banco");
        }
        if(banco.getRa()==null || banco.getRa().isBlank() || banco.getRa().isEmpty()){
            throw new CampoNaoInformadaException("RA");
        }
        if(banco.getRa().length()!=8){
            throw new CaracteresInvalidosException("RA", 8);
        }
        if(banco.getNmBanco().length()>60){
            throw new MaximoTamanhoException("Nome do banco", 60);
        }
    }
    public List findAll()throws SQLException{
        BancoDAO bancoDAO = new BancoDAO();
        List<Banco> resultado = bancoDAO.findAll();
        return resultado;
    }
    public Banco findById(int id) throws SQLException, IdInvalidoException, NaoEncontradoException{
        if(id<=0){
            throw new IdInvalidoException("Banco");
        }
        BancoDAO bancoDAO = new BancoDAO();
        Banco resultado = bancoDAO.findById(id);
        
        if(resultado ==null){
            throw new NaoEncontradoException("Banco");
        }
        return resultado;
    }
    public void insert(Banco banco)throws SQLException, EntidadeInvalidoException, CampoNaoInformadaException, MaximoTamanhoException, CaracteresInvalidosException{
        validar(banco);
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.insert(banco);
    }
    public void update(Banco banco)throws SQLException, EntidadeInvalidoException, CampoNaoInformadaException, MaximoTamanhoException, CaracteresInvalidosException{
        validar(banco);
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.update(banco);
    }
    public void delete(int id)throws SQLException{
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.delete(id);
    }
}
