package br.unipar.bancopoo.repositories;

import br.unipar.bancopoo.models.AbstractBaseEntity;
import br.unipar.bancopoo.models.Estado;
import br.unipar.bancopoo.models.Pais;
import br.unipar.bancopoo.utils.DataBaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO implements PrincipalDAO{
    private static final String INSERT = 
            "INSERT INTO estado (id,nome,sigla,ra,pais_id) VALUES(?,?,?,?,?)";
    
    private static final String FIND_ALL =
            "SELECT id,nome,sigla,ra,pais_id FROM estado";
    
    private static final String FIND_BY_ID = 
            "SELECT id,nome,sigla,ra,pais_id FROM estado WHERE id = ?";
    
    private static final String DELETE_BY_ID =
            "DELETE FROM pais WHERE id = ?";
    
    private static final String UPDATE = 
            "UPDATE pais SET nome=?,sigla=?,ra=?,pais_id WHERE id=?";
    
    
    public void insert(Estado estado) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, estado.getId());
            pstmt.setString(2, estado.getNmEstado());
            pstmt.setString(3, estado.getSgEstado());
            pstmt.setString(4, estado.getRa());
            pstmt.setInt(5, estado.getPais().getId());
            
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
    
    public void update(Estado estado) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
        
            pstmt.setString(1, estado.getNmEstado());
            pstmt.setString(2, estado.getSgEstado());
            pstmt.setString(3, estado.getRa());
            pstmt.setInt(4, estado.getPais().getId());
            pstmt.setInt(5, estado.getId());
            
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
            pstmt = conn.prepareCall(DELETE_BY_ID);
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
    
    public Estado findById(int id) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Estado retorno = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new Estado();
                retorno.setId(rs.getInt("id"));
                retorno.setNmEstado(rs.getString("nome"));
                retorno.setSgEstado(rs.getString("sigla"));
                retorno.setRa(rs.getString("ra"));
                retorno.setPais(new PaisDAO().findById(rs.getInt("pais_id")));
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
    
    public List<Estado> findAll() throws SQLException{
        ArrayList<Estado> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                Estado estado = new Estado();
                estado.setId(rs.getInt("id"));
                estado.setNmEstado(rs.getString("nome"));
                estado.setSgEstado(rs.getString("sigla"));
                estado.setRa(rs.getString("ra"));
                
                PaisDAO paisDAO = new PaisDAO();
                Pais pais = paisDAO.findById(rs.getInt("pais_id"));
                estado.setPais(pais);

                retorno.add(estado);
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
