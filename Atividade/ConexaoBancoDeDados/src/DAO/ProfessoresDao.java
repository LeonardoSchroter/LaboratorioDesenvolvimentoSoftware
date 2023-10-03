/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Beans.Pessoa;
import Beans.Professores;
import conexaobancodedados.Conexao;
import java.awt.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author laboratorio
 */
public class ProfessoresDao {
    
    private Conexao conexao;
    private Connection conn;

    public ProfessoresDao() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao("escola");
    }
    
    public void inserir(Professores p){
        String sql = "INSERT INTO professores (nome,idade,disciplina) VALUES (?,?,?);";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,p.getNome());
            stmt.setInt(2,p.getIdade());
            stmt.setString(3,p.getDisciplina());
            
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir professor: "+ex.getMessage());
        }
        
    }
}
