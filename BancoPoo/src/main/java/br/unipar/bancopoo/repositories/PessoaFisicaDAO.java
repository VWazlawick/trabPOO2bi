package br.unipar.bancopoo.repositories;

import br.unipar.bancopoo.models.PessoaFisica;
import br.unipar.bancopoo.utils.DataBaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAO {

    public static final String INSERT = "INSERT INTO pessoafisica(nome,cpf,rg,datanascimento,pessoa_id) VALUES"
            + "(?,?,?,?,?)";
    public static final String UPDATE = "UPDATE pessoafisica SET nome=?,cpf=?,rg=?,datanascimento=?,pessoa_id WHERE pessoa_id =?";
    public static final String DELETE = "DELETE FROM pessoafisica WHERE pessoa_id = ?";
    public static final String FIND_ALL = "SELECT nome,cpf,rg,datanascimento,pessoa_id FROM pessoafisica";
    public static final String FIND_BY_ID = "SELECT nome,cpf,rg,datanascimento FROM pessoafisica WHERE pessoa_id = ?";
    
    public void insert(PessoaFisica pessoaFisica) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = pstmt.getGeneratedKeys();
            pstmt.setString(1, pessoaFisica.getNmPessoa());
            pstmt.setString(2, pessoaFisica.getCpf());
            pstmt.setString(3, pessoaFisica.getRg());
            pstmt.setDate(4, pessoaFisica.getDtnasc());
            pstmt.setInt(5, pessoaFisica.getId());
            
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
    
    public void update(PessoaFisica pessoaFisica) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setString(1, pessoaFisica.getNmPessoa());
            pstmt.setString(2, pessoaFisica.getCpf());
            pstmt.setString(3, pessoaFisica.getRg());
            pstmt.setDate(4, pessoaFisica.getDtnasc());
            pstmt.setInt(5, pessoaFisica.getId());
            
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
        ArrayList<PessoaFisica> retorno = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new ArrayList<>();
                PessoaFisica pessoaFisica = new PessoaFisica();
                
                pessoaFisica.setNmPessoa(rs.getString("nome"));
                pessoaFisica.setCpf(rs.getString("cpf"));
                pessoaFisica.setRg(rs.getString("rg"));
                pessoaFisica.setDtnasc(rs.getDate("datanascimento"));
                pessoaFisica.setId(rs.getInt("pessoa_id"));
                
                retorno.add(pessoaFisica);
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
    
    public PessoaFisica findById(int id) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaFisica retorno = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new PessoaFisica();
                retorno.setNmPessoa(rs.getString("nome"));
                retorno.setCpf(rs.getString("cpf"));
                retorno.setRg(rs.getString("rg"));
                retorno.setDtnasc(rs.getDate("datanascimento"));
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
}
