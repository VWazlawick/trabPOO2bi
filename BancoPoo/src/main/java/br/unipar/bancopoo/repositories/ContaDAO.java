package br.unipar.bancopoo.repositories;

import br.unipar.bancopoo.Enums.TipoContaEnum;
import br.unipar.bancopoo.models.Agencia;
import br.unipar.bancopoo.models.Conta;
import br.unipar.bancopoo.utils.DataBaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {
    
    public static final String INSERT = "INSERT INTO conta(numero,digito,saldo,tipo,ra,agencia_id,pessoa_id) VALUES(?,?,?,?,?,?,?)";
    public static final String UPDATE = "UPDATE conta SET numero=?,digito=?,saldo=?,tipo=?,ra=?,agencia_id=?,pessoa_id=? WHERE id=?";
    public static final String DELETE = "DELETE FROM conta WHERE id=?";
    public static final String FIND_ALL = "SELECT id,numero,digito,saldo,tipo,ra,agencia_id,pessoa_id FROM conta";
    public static final String FIND_BY_ID = "SELECT id,numero,digito,saldo,tipo,ra,agencia_id,pessoa_id FROM conta WHERE id=?";
    
    public void insert(Conta conta)throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            
            pstmt.setString(1, conta.getNrConta());
            pstmt.setString(2, conta.getDigito());            
            pstmt.setDouble(3, conta.getSaldo());            
            pstmt.setInt(4, conta.getTipo().getCodigo());                      
            pstmt.setString(5, conta.getRa());                      
            pstmt.setInt(6, conta.getAgencia().getId());
            pstmt.setInt(7, conta.getPessoa().getId());                      
            
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
    public void update(Conta conta) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setString(1, conta.getNrConta());
            pstmt.setString(2, conta.getDigito());            
            pstmt.setDouble(3, conta.getSaldo());            
            pstmt.setInt(4, conta.getTipo().getCodigo());                      
            pstmt.setString(5, conta.getRa());                      
            pstmt.setInt(6, conta.getAgencia().getId());
            pstmt.setInt(7, conta.getPessoa().getId()); 
            pstmt.setInt(8, conta.getId());
            
            
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
        ArrayList<Conta> retorno = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new ArrayList<>();
                Conta conta = new Conta();
                
                conta.setId(rs.getInt("id"));
                conta.setNrConta(rs.getString("numero"));
                conta.setDigito(rs.getString("digito"));
                conta.setSaldo(rs.getDouble("saldo"));
                if(rs.getInt("tipo")==1){
                    conta.setTipo(TipoContaEnum.CONTA_CORRENTE);
                }else if(rs.getInt("tipo")==2){
                    conta.setTipo(TipoContaEnum.POUPANCA);
                }else if(rs.getInt("tipo")==3){
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
                
                retorno.setId(rs.getInt("id"));
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
