package br.unipar.bancopoo.repositories;

import br.unipar.bancopoo.Enums.OperadoraEnum;
import br.unipar.bancopoo.models.Agencia;
import br.unipar.bancopoo.utils.DataBaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgenciaDAO {
    public static final String INSERT = "INSERT INTO agencia(id,codigo,digito,razaosocial,cnpj,ra,banco_id)VALUES()";
    public static final String UPDATE = "UPDATE agencia SET codigo=?,digito=?,razaosocial=?,cnpj=?,ra=?,banco_id=? WHERE id=?";
    public static final String DELETE = "DELETE FROM agencia WHERE id=?";
    public static final String FIND_ALL = "SELECT id,codigo,digito,razaosocial,cpj,ra,banco_id FROM agencia";
    public static final String FIND_BY_ID = "SELECT codigo,digito,razaosocial,cnpj,ra,banco_id FROM agencia WHERE=?";
    
    public void insert(Agencia agencia)throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            
            pstmt.setInt(1, agencia.getId());
            pstmt.setString(2, agencia.getCodigo());            
            pstmt.setString(3, agencia.getDigito());            
            pstmt.setString(4, agencia.getRazaoSocial());                      
            pstmt.setString(5, agencia.getCnpj());                      
            pstmt.setString(6, agencia.getRa());                      
            pstmt.setInt(7, agencia.getBanco().getId());                      
            
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
    public void update(Agencia agencia) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setString(1, agencia.getCodigo());
            pstmt.setString(2, agencia.getDigito());
            pstmt.setString(3, agencia.getRazaoSocial());
            pstmt.setString(4, agencia.getRazaoSocial());
            pstmt.setString(5, agencia.getRa());
            pstmt.setInt(6, agencia.getBanco().getId());
            pstmt.setInt(7, agencia.getId());
            
            
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
        ArrayList<Agencia> retorno = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new ArrayList<>();
                Agencia agencia = new Agencia();
                
                agencia.setId(rs.getInt("id"));
                agencia.setCodigo(rs.getString("codigo"));
                agencia.setDigito(rs.getString("digito"));
                agencia.setRazaoSocial(rs.getString("razaosocial"));
                agencia.setCnpj(rs.getString("cnpj"));
                agencia.setRa(rs.getString("ra"));
                agencia.setBanco(new BancoDAO().findById(rs.getInt("banco_id")));
                
                retorno.add(agencia);
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
    public Agencia findById(int id) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null; 
        ResultSet rs = null;
        Agencia retorno = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new Agencia();
                
                retorno.setCodigo(rs.getString("codigo"));
                retorno.setDigito(rs.getString("digito"));
                retorno.setRazaoSocial(rs.getString("razaosocial"));
                retorno.setCnpj(rs.getString("cnpj"));
                retorno.setRa(rs.getString("ra"));
                retorno.setBanco(new BancoDAO().findById(rs.getInt("banco_id")));
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
