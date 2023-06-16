package br.unipar.bancopoo.repositories;

import br.unipar.bancopoo.Enums.TipoTransacaoEnum;
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
                Transacao transacao = new Transacao();
                
                transacao.setId(rs.getInt("id"));
                transacao.setDhTransacao(rs.getDate("datahora"));
                transacao.setValor(rs.getDouble("valor"));
                if(rs.getInt("tipo") == 1){
                    transacao.setTipo(TipoTransacaoEnum.PIX);
                }else if(rs.getInt("tipo")==2){
                    transacao.setTipo(TipoTransacaoEnum.TRANSFERENCIA);
                }
                transacao.setRa(rs.getString("ra"));
                transacao.setContaOrigem(new ContaDAO().findById(rs.getInt("conta_origem")));
                transacao.setContaDestino(new ContaDAO().findById(rs.getInt("conta_destino")));
                
                retorno.add(transacao);
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
    public Transacao findById(int id) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null; 
        ResultSet rs = null;
        Transacao retorno = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new Transacao();
                
                retorno.setDhTransacao(rs.getDate("datahora"));
                retorno.setValor(rs.getDouble("valor"));
                if(rs.getInt("tipo") == 1){
                    retorno.setTipo(TipoTransacaoEnum.PIX);
                }else if(rs.getInt("tipo")==2){
                    retorno.setTipo(TipoTransacaoEnum.TRANSFERENCIA);
                }
                retorno.setRa(rs.getString("ra"));
                retorno.setContaOrigem(new ContaDAO().findById(rs.getInt("conta_origem")));
                retorno.setContaDestino(new ContaDAO().findById(rs.getInt("conta_destino")));
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
