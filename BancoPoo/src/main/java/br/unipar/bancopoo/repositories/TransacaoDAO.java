package br.unipar.bancopoo.repositories;

import br.unipar.bancopoo.Enums.TipoContaEnum;
import br.unipar.bancopoo.models.Conta;
import br.unipar.bancopoo.models.Transacao;
import br.unipar.bancopoo.utils.DataBaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {
    
    public static final String INSERT = "INSERT INTO trasacao(datahora,valor,tipo,ra,conta_origem,conta_destino) VALUES(?,?,?,?,?,?)";
    public static final String UPDATE = "UPDATE transacao SET datahora=?,valor=?,tipo=?,ra=?,conta_origem=?,conta_destino=? WHERE id=?";
    public static final String DELETE = "DELETE FROM transacao WHERE id=?";
    public static final String FIND_ALL = "SELECT id,datahora,valor,tipo,ra,conta_origem,conta_destino FROM transacao";
    public static final String FIND_BY_ID = "SEKECT datahora,valor,tipo,ra,conta_origem,conta_destino FROM transacao WHERE id=?";
    
    public void insert(Transacao transacao)throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            
            pstmt.setDate(1, transacao.getDhTransacao());
            pstmt.setDouble(2, transacao.getValor());            
            pstmt.setInt(3, transacao.getTipo().getCodigo());                              
            pstmt.setString(4, transacao.getRa());                      
            pstmt.setInt(5, transacao.getContaOrigem().getId());
            pstmt.setInt(6, transacao.getContaDestino().getId());                      
            
            pstmt.executeUpdate();
        } finally {
            if(pstmt!=null){
                pstmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
    }
    public void update(Transacao transacao) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setDate(1, transacao.getDhTransacao());
            pstmt.setDouble(2, transacao.getValor());            
            pstmt.setInt(3, transacao.getTipo().getCodigo());                              
            pstmt.setString(4, transacao.getRa());                      
            pstmt.setInt(5, transacao.getContaOrigem().getId());
            pstmt.setInt(6, transacao.getContaDestino().getId());   
            pstmt.setInt(7, transacao.getId());
            
            pstmt.executeUpdate();
        } finally {
            if(pstmt!=null){
                pstmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
    }
     public void delete(int id) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
        } finally {
            if(pstmt!=null){
                pstmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
    }
     public List findAll() throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Transacao> retorno = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new ArrayList<>();
                Transacao transacao = new Tramsacao();
                
                conta.setId(rs.getInt("id"));
                conta.setNrConta(rs.getString("numero"));
                conta.setDigito(rs.getString("digito"));
                conta.setSaldo(rs.getDouble("saldo"));
                if(rs.getString("tipo").equals("1")){
                    conta.setTipo(TipoContaEnum.CONTA_CORRENTE);
                }else if(rs.getString("tipo").equals("2")){
                    conta.setTipo(TipoContaEnum.POUPANCA);
                }else if(rs.getString("tipo").equals("3")){
                    conta.setTipo(TipoContaEnum.SALARIO);
                }
                conta.setRa(rs.getString("ra"));
                conta.setAgencia(new AgenciaDAO().findById(rs.getInt("agencia_id")));
                conta.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
                
                retorno.add(conta);
            }
            
        } finally {
            if(pstmt!=null){
                pstmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
        return retorno;
    }
    public Conta findById(int id) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null; 
        ResultSet rs = null;
        Conta retorno = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new Conta();
                
                retorno.setNrConta(rs.getString("numero"));
                retorno.setDigito(rs.getString("digito"));
                retorno.setSaldo(rs.getDouble("saldo"));
                if(rs.getString("tipo").equals("1")){
                    retorno.setTipo(TipoContaEnum.CONTA_CORRENTE);
                }else if(rs.getString("tipo").equals("2")){
                    retorno.setTipo(TipoContaEnum.POUPANCA);
                }else if(rs.getString("tipo").equals("3")){
                    retorno.setTipo(TipoContaEnum.SALARIO);
                }
                retorno.setRa(rs.getString("ra"));
                retorno.setAgencia(new AgenciaDAO().findById(rs.getInt("agencia_id")));
                retorno.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
            }
        } finally {
            if(pstmt!=null){
                pstmt.close();
            }
            if(conn!=null){
                conn.close();
            }
            if(rs!=null){
                rs.close();
            }
        }
        return retorno;
    }
}
