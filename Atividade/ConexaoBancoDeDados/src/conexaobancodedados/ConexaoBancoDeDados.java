/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexaobancodedados;

import Beans.Pessoa;
import DAO.PessoaDao;

/**
 *
 * @author laboratorio
 */
public class ConexaoBancoDeDados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexao c =  new Conexao();
        c.getConexao("bdaula01");
        
        Pessoa p = new Pessoa();
        p.setNome("Leonardo");
        p.setSexo("M");
        p.setIdioma("Portugues");
        
        PessoaDao pDao= new PessoaDao();
        pDao.inserir(p);
    }
    
}
