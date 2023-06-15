package br.unipar.bancopoo.services;
import br.unipar.bancopoo.exceptions.CaracteresInvalidosException;
import br.unipar.bancopoo.models.Pessoa;
import br.unipar.bancopoo.exceptions.EntidadeInvalidoException;
import br.unipar.bancopoo.exceptions.IdInvalidoException;
import br.unipar.bancopoo.exceptions.MaximoTamanhoException;
import br.unipar.bancopoo.exceptions.NaoEncontradoException;
import br.unipar.bancopoo.repositories.PessoaDAO;
import java.sql.SQLException;
import java.util.List;


public class PessoaService {
    public void validar(Pessoa pessoa) throws EntidadeInvalidoException, MaximoTamanhoException, CaracteresInvalidosException{
        if(pessoa==null){
            throw new EntidadeInvalidoException("Pessoa");
        }
        if(pessoa.getRa().length()!=8){
            throw new CaracteresInvalidosException("RA", 8);
        }
        if(pessoa.getEmail().length()>60){
            throw new MaximoTamanhoException("Email", 60);
        }
    }
    public List<Pessoa> findAll() throws SQLException{
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> retorno = pessoaDAO.findAll();
        return retorno;
    }
    public Pessoa findById(int id) throws SQLException, IdInvalidoException, NaoEncontradoException{
        if(id<=0){
            throw new IdInvalidoException("Pessoa");
        }
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa retorno = pessoaDAO.findById(id);
        
        if(retorno==null){
            throw new NaoEncontradoException("Pessoa");
        }
        return retorno;
    }
    public void insert(Pessoa pessoa) throws SQLException, EntidadeInvalidoException, MaximoTamanhoException, CaracteresInvalidosException{
        validar(pessoa);
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.insert(pessoa);
    }
    public void update(Pessoa pessoa) throws SQLException, EntidadeInvalidoException, MaximoTamanhoException, CaracteresInvalidosException{
        validar(pessoa);
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.update(pessoa);
    }
    public void delete(int id)throws SQLException{
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.delete(id);
    }
}
