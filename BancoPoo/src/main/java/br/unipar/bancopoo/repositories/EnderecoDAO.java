package br.unipar.bancopoo.repositories;

import br.unipar.bancopoo.models.Endereco;
import br.unipar.bancopoo.models.Pessoa;
import br.unipar.bancopoo.utils.DataBaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO implements PrincipalDAO{

    private static final String INSERT = "INSERT INTO endereco"
            + "(logradouro,numero,bairro,cep,complemento,ra,pessoa_id,cidade_id) VALUES (?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE endereco SET logradouro=?,numero=?,bairro=?,cep=?,complemento=?"
            + ",ra=?,pessoa_id=?,cidade_id=? WHERE id=?";
    private static final String DELETE ="DELETE FROM endereco WHERE id=?";
    private static final String FIND_BY_ID = "SELECT id,logradouro,numero,bairro,cep,complemento,ra,pessoa_id,cidade_id"
            + " FROM endereco WHERE id=?";
    private static final String FIND_ALL = "SELECT id,logradouro,numero,bairro,cep,complemento,ra,pessoa_id,cidade_id,"
            + " FROM endereco";
    
    @Override
    public List<Endereco> findAll() throws SQLException {
        ArrayList<Endereco> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                Endereco endereco = new Endereco();
                endereco.setNmRua(rs.getString("logradouro"));
                endereco.setNrCasa(rs.getString("numero"));
                endereco.setNmBairro(rs.getString("bairro"));
                endereco.setCep(rs.getString("cep"));
                endereco.setDsComplemente(rs.getString("complemento"));
                endereco.setRa(rs.getString("ra"));
                
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("pessoa_id"));
                endereco.setPessoa(pessoa);
                                
                endereco.setCidade(new CidadeDAO().findById(rs.getInt("cidade_id")));
                
                retorno.add(endereco);
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
    public Endereco findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Endereco retorno = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new Endereco();
                retorno.setNmRua(rs.getString("logradouro"));
                retorno.setNrCasa(rs.getString("numero"));
                retorno.setNmBairro(rs.getString("bairro"));
                retorno.setCep(rs.getString("cep"));
                retorno.setDsComplemente(rs.getString("complemento"));
                retorno.setRa(rs.getString("ra"));
                retorno.setCidade(new CidadeDAO().findById(rs.getInt("cidade_int")));
                
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("pessoa_id"));
                retorno.setPessoa(pessoa);                
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

    public void insert(Endereco endereco) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, endereco.getNmRua());
            pstmt.setString(2, endereco.getNrCasa());
            pstmt.setString(3, endereco.getNmBairro());
            pstmt.setString(4, endereco.getCep());
            pstmt.setString(5, endereco.getDsComplemente());
            pstmt.setString(6, endereco.getRa());
            pstmt.setInt(7, endereco.getPessoa().getId());
            pstmt.setInt(8, endereco.getCidade().getId());
            
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

    public void update(Endereco endereco) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, endereco.getNmRua());
            pstmt.setString(2, endereco.getNrCasa());
            pstmt.setString(3, endereco.getNmBairro());
            pstmt.setString(4, endereco.getCep());
            pstmt.setString(5, endereco.getDsComplemente());
            pstmt.setString(6, endereco.getRa());
            pstmt.setInt(7, endereco.getPessoa().getId());
            pstmt.setInt(8, endereco.getCidade().getId());
            pstmt.setInt(9, endereco.getId());
            
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
