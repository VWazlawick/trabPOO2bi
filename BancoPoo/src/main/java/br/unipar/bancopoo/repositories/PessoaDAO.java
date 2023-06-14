package br.unipar.bancopoo.repositories;

import br.unipar.bancopoo.models.AbstractBaseEntity;
import br.unipar.bancopoo.models.Pessoa;
import br.unipar.bancopoo.utils.DataBaseUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO implements PrincipalDAO{

    public static final String INSERT = "INSERT INTO pessoa(email,ra) VALUES (?,?)";
    public static final String UPDATE = "UPDATE pessoa SET email=?, ra=? WHERE id =?";
    public static final String FIND_BY_ID = "SELECT id,email,ra FROM pessoa WHERE id = ?";
    public static final String FIND_ALL = "SELECT id,email,ra FROM pessoa";
    public static final String DELETE = "DELETE FROM pessoa WHERE id=?";
    
    public void insert(Pessoa pessoa) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            
            pstmt.setString(1, pessoa.getEmail());
            pstmt.setString(2, pessoa.getRa());
            
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
    
    public void update(Pessoa pessoa) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setString(1, pessoa.getEmail());
            pstmt.setString(2, pessoa.getRa());
            pstmt.setInt(3, pessoa.getId());
            
            pstmt.executeUpdate();
        }finally{
            if(pstmt!=null){
                pstmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    @Override
    public List findAll() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Pessoa> retorno = null;
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new ArrayList<>();
                Pessoa pessoa = new Pessoa();
                
                pessoa.setId(rs.getInt("id"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setRa(rs.getString("ra"));
                
                retorno.add(pessoa);
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

    @Override
    public Pessoa findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Pessoa retorno = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new Pessoa();
                retorno.setId(rs.getInt("id"));
                retorno.setEmail(rs.getString("email"));
                retorno.setRa(rs.getString("ra"));
                            
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

    @Override
    public void delete(int id) throws SQLException {
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
    
}
