/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Beans.Pessoa;
import com.mysql.cj.jdbc.result.ResultSetFactory;
import conexaobancodedados.Conexao;
import java.awt.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laboratorio
 */
public class PessoaDao {

    private Conexao conexao;
    private Connection conn;

    public PessoaDao() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao("bdaula01");
    }

    public void inserir(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome,sexo,idioma) VALUES (?,?,?);";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getIdioma());

            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir pessoa: " + ex.getMessage());
        }

    }

    public Pessoa getPessoa(int id) {
        String sql = "SELECT * FROM pessoa Where id = ?";
        try {
            PreparedStatement smt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            smt.setInt(1, id);
            ResultSet rs = smt.executeQuery();

            Pessoa p = new Pessoa();

            rs.first();

            p.setId(id);
            p.setNome(rs.getString("nome"));
            p.setSexo(rs.getString("sexo"));
            p.setIdioma(rs.getString("idioma"));

            return p;

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar pessoa: " + ex.getMessage());
            return null;
        }
    }

    public void editar(Pessoa p) {
        try {
            String sql = "UPDATE pessoa set nome=?, sexo=?, idioma=? where id=?";
            PreparedStatement smt = conn.prepareStatement(sql);
            smt.setString(1, p.getNome());
            smt.setString(2, p.getSexo());
            smt.setString(3, p.getIdioma());
            smt.setInt(4, p.getId());
            smt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar pessoa: " + ex.getMessage());
        }
    }

    public void Excluir(int id) {
        try {
            String sql = "delete from pessoa where id=?";

            PreparedStatement smt = conn.prepareStatement(sql);
            smt.setInt(1, id);
            smt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir pessoa: "+ex.getMessage());
        }
    }

}
