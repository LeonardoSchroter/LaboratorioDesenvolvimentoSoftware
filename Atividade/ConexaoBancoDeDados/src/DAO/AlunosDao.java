/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Beans.Alunos;
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
public class AlunosDao {
      private Conexao conexao;
    private Connection conn;

    public AlunosDao() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao("escola");
    }
    
    public void inserir(Alunos a){
        String sql = "INSERT INTO alunos (nome,idade,curso) VALUES (?,?,?);";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,a.getNome());
            stmt.setInt(2,a.getIdade());
            stmt.setString(3,a.getCurso());
            
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir aluno: "+ex.getMessage());
        }
    }
}
