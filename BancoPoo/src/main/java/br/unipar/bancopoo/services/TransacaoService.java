package br.unipar.bancopoo.services;

import br.unipar.bancopoo.exceptions.EntidadeInvalidoException;
import br.unipar.bancopoo.exceptions.IdInvalidoException;
import br.unipar.bancopoo.exceptions.NaoEncontradoException;
import br.unipar.bancopoo.exceptions.ValorInvalidoException;
import br.unipar.bancopoo.models.Transacao;
import br.unipar.bancopoo.repositories.TransacaoDAO;
import java.sql.SQLException;
import java.util.List;

public class TransacaoService {
    public void validar(Transacao transacao) throws EntidadeInvalidoException, ValorInvalidoException{
        if(transacao==null){
            throw new EntidadeInvalidoException("Transação");
        }
        if(transacao.getValor()<=0){
            throw new ValorInvalidoException("Transação");
        }
        if(transacao.getContaOrigem()==null){
            throw new EntidadeInvalidoException("Conta Origem");
        }
        if(transacao.getContaDestino()==null){
            throw new EntidadeInvalidoException("ContaDestino");
        }
        if(transacao.getTipo()==null){
            throw new EntidadeInvalidoException("Tipo de Transação");
        }
    }
    public List findAll()throws SQLException{
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        List<Transacao> retorno = transacaoDAO.findAll();
        return retorno;
    }
    public Transacao findById(int id)throws SQLException, IdInvalidoException, NaoEncontradoException{
        if(id<=0){
            throw new IdInvalidoException("ID");
        }
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        Transacao retorno = transacaoDAO.findById(id);
        
        if(retorno==null){
            throw new NaoEncontradoException("Transação");
        }
        return retorno;
    }
    public void insert(Transacao transacao) throws SQLException, EntidadeInvalidoException, ValorInvalidoException{
        validar(transacao);
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.insert(transacao);
    }
    public void update(Transacao transacao) throws SQLException, EntidadeInvalidoException, ValorInvalidoException{
        validar(transacao);
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.update(transacao);
    }
    public void delete(int id) throws SQLException{
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.delete(id);
    }
}
