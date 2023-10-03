/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexaobancodedados;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laboratorio
 */
public class Conexao {
    public Connection getConexao(String BD){
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/"+BD+"?useTimezone=true&serverTimezone=UTC",
                    "root","laboratorio");
            System.out.println("Conexao bem sucedida!");
            return conn;
        } catch (Exception e) {
            System.out.println("Erro ao conectar no BD "+e.getMessage());
            return null;
        }
    }
}
