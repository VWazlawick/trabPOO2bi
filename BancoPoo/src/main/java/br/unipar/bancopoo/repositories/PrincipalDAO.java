package br.unipar.bancopoo.repositories;

import br.unipar.bancopoo.models.AbstractBaseEntity;
import java.sql.SQLException;
import java.util.List;

public interface PrincipalDAO {
    List findAll()throws SQLException;
    Estado findById(int id)throws SQLException;
    void delete(int id) throws SQLException;
}
