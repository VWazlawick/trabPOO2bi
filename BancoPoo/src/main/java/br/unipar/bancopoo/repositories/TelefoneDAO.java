package br.unipar.bancopoo.repositories;

import br.unipar.bancopoo.Enums.OperadoraEnum;
import br.unipar.bancopoo.models.Agencia;
import br.unipar.bancopoo.models.Telefone;
import br.unipar.bancopoo.utils.DataBaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelefoneDAO {

    public static final String INSERT = "INSERT INTO telefone(numero,operadora,ra,agencia_id,pessoa_id) VALUES(?,?,?,?,?)";
    public static final String UPDATE = "UPDATE telefone SET numero=?,operadora=?,ra=?,agencia_id=?,pessoa_id=? WHERE id=?";
    public static final String DELETE = "DELETE FROM telefone WHERE id=?";
    public static final String FIND_ALL = "SELECT numero,operadora,ra,agencia_id,pessoa_id FROM telefone";
    public static final String FIND_BY_ID = "SELECT numero,operadora,ra,agencia_id,pessoa_id FROM telefone WHERE id=?";
    
    public void insert(Telefone telefone)throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            
            pstmt.setString(1, telefone.getNrTelefone());
            pstmt.setInt(2, telefone.getOperadora().getCodigo());            
            pstmt.setString(3, telefone.getRa());            
            pstmt.setInt(4, telefone.getAgencia().getId());            
            pstmt.setInt(5, telefone.getPessoa().getId());            
            
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
    public void update(Telefone telefone) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setString(1, telefone.getNrTelefone());
            pstmt.setInt(2, telefone.getOperadora().getCodigo());
            pstmt.setString(3, telefone.getRa());
            pstmt.setInt(4, telefone.getAgencia().getId());
            pstmt.setInt(5, telefone.getPessoa().getId());
            pstmt.setInt(5, telefone.getId());
            
            
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
        ArrayList<Telefone> retorno = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new ArrayList<>();
                Telefone telefone = new Telefone();
                
                telefone.setId(rs.getInt("id"));
                telefone.setNrTelefone(rs.getString("numero"));
                if(rs.getString("operadora")=="41"){
                    telefone.setOperadora(OperadoraEnum.TIM);
                }else if(rs.getString("operadora")=="15"){
                    telefone.setOperadora(OperadoraEnum.VIVO);
                }else if(rs.getString("operadora")=="21"){
                    telefone.setOperadora(OperadoraEnum.CLARO);
                }else if(rs.getString("operadora")=="31"){
                    telefone.setOperadora(OperadoraEnum.OI);
                }
                telefone.setAgencia(new AgenciaDAO().findById(rs.getInt("agencia_id")));
                telefone.setPessoa(new  PessoaDAO().findById(rs.getInt("pessoa_id")));
                
                retorno.add(telefone);
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
    public Telefone findById(int id) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null; 
        ResultSet rs = null;
        Telefone retorno = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new Telefone();
                retorno.setNrTelefone(rs.getString("numero"));
                if(rs.getString("operadora")=="41"){
                    retorno.setOperadora(OperadoraEnum.TIM);
                }else if(rs.getString("operadora")=="15"){
                    retorno.setOperadora(OperadoraEnum.VIVO);
                }else if(rs.getString("operadora")=="21"){
                    retorno.setOperadora(OperadoraEnum.CLARO);
                }else if(rs.getString("operadora")=="31"){
                    retorno.setOperadora(OperadoraEnum.OI);
                }
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
