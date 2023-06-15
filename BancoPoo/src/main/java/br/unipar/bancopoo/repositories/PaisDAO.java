package br.unipar.bancopoo.repositories;

import br.unipar.bancopoo.models.AbstractBaseEntity;
import java.util.List;
import br.unipar.bancopoo.models.Pais;
import br.unipar.bancopoo.utils.DataBaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PaisDAO{

    private static final String INSERT = "INSERT INTO PAIS(id,nome,sigla,ra)"+
        "VALUES(?,?,?,?)";
    
    private static final String FIND_ALL = "SELECT id,nome,sigla,ra FROM pais";
    
    private static final String FIND_BY_ID = "SELECT id,nome,sigla,ra FROM pais"
            + "WHERE id = ?";
    
    private static final String DELETE_BY_ID = "DELETE FROM pais WHERE id = ?";
    
    private static final String UPDATE = "UPDATE pais SET nome=?,sigla=?,ra=? WHERE id =?";
    
    public List<Pais> findAll() throws SQLException{
        ArrayList<Pais> retorno = new ArrayList<>();
        Connection conn = null; 
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
           conn = new DataBaseUtils().getConnection();
           pstmt = conn.prepareStatement(FIND_ALL);
           
           rs=pstmt.executeQuery();
           
           while(rs.next()){
               Pais pais = new Pais();
               pais.setId(rs.getInt("id"));
               pais.setNmPais(rs.getString("nome"));
               pais.setSgPais(rs.getString("sigla"));
               pais.setRa(rs.getString("ra"));
               
               retorno.add(pais);
           }
        } finally {
            if(rs!=null){
            rs.close();
            }
            
            if(conn!=null){
                conn.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
        }
        return retorno;
    }
    
    public Pais findById(int id) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Pais retorno = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new Pais();
                retorno.setId(rs.getInt("ID"));
                retorno.setNmPais(rs.getString("NOME"));
                retorno.setRa(rs.getString("RA"));
                retorno.setSgPais(rs.getString("SIGLA"));
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
    
    public void insert(Pais pais) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
                
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, pais.getId());
            pstmt.setString(2, pais.getNmPais());
            pstmt.setString(3, pais.getSgPais());
            pstmt.setString(4,pais.getRa());
            
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
    public void update(Pais pais) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt =null;
                
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, pais.getNmPais());
            pstmt.setString(2, pais.getSgPais());
            pstmt.setString(3, pais.getRa());
            pstmt.setInt(4, pais.getId());

            pstmt.executeUpdate();
        } finally{
            if(pstmt!=null){
                pstmt.close();
            }
            if(conn!=null){
                pstmt.close();
            }
        }
    }

    public void delete(int id)throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
        } finally {
            if(conn!=null){
                conn.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
        }
    }

    
}
