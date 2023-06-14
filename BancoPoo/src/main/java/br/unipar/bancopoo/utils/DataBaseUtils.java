package br.unipar.bancopoo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtils {
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
        "jdbc:postgresql://3.142.131.90:5435/uniparcentral",
        "aluno",
        "aluno");      
    }
 }

