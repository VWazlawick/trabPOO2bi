package br.unipar.bancopoo.repositories;

import br.unipar.bancopoo.models.PessoaFisica;
import br.unipar.bancopoo.models.PessoaJuridica;
import static br.unipar.bancopoo.repositories.PessoaFisicaDAO.DELETE;
import static br.unipar.bancopoo.repositories.PessoaFisicaDAO.FIND_ALL;
import static br.unipar.bancopoo.repositories.PessoaFisicaDAO.UPDATE;
import br.unipar.bancopoo.utils.DataBaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO {
    public static final String INSERT = "INSERT INTO pessoajuridica(razaosocial,cnpj,cnaeprincipal,fantasia,pessoa_id)"
            + "VALUES (?,?,?,?,?)";
    public static final String UPDATE = "UPDATE pessoajuridica SET razaosocial=?,cnpj=?,cnaeprincipal=?,fantasia=?"
            + " WHERE pessoa_id = ?";
    public static final String DELETE = "DELETE FROM pessoajuridica WHERE pessoa_id=?";
    public static final String FIND_ALL = "SELECT razaosocial,cnpj,cnaeprincipal,fantasia,pessoa_id FROM pessoajuridica";
    public static final String FIND_BY_ID = "SELECT razaosocial,cnpj,cnaeprincipal,fantasia FROM pessoajuridica WHERE pessoa_id =?";
    
    public void insert(PessoaJuridica pessoaJuridica)throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            
            pstmt.setString(1, pessoaJuridica.getRazaoSocial());
            pstmt.setString(2, pessoaJuridica.getCnpj());
            pstmt.setString(3, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(4, pessoaJuridica.getFantasia());
            pstmt.setInt(5, pessoaJuridica.getId());
            
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
    public void update(PessoaJuridica pessoaJuridica) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setString(1, pessoaJuridica.getRazaoSocial());
            pstmt.setString(2, pessoaJuridica.getCnpj());
            pstmt.setString(3, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(4, pessoaJuridica.getFantasia());
            pstmt.setInt(5, pessoaJuridica.getId());
            
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
        ArrayList<PessoaJuridica> retorno = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new ArrayList<>();
                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                
                pessoaJuridica.setRazaoSocial(rs.getString("razaosocial"));
                pessoaJuridica.setCnpj(rs.getString("cnpj"));
                pessoaJuridica.setCnaePrincipal(rs.getString("cnaeprincipal"));
                pessoaJuridica.setFantasia(rs.getString("fantasia"));
                pessoaJuridica.setId(rs.getInt("pessoa_id"));
                
                retorno.add(pessoaJuridica);
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
    public PessoaJuridica findById(int id) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaJuridica retorno = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new PessoaJuridica();
                retorno.setRazaoSocial(rs.getString("razaosocial"));
                retorno.setCnpj(rs.getString("cnpj"));
                retorno.setCnaePrincipal(rs.getString("cnaeprincipal"));
                retorno.setFantasia(rs.getString("fantasi"));
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
