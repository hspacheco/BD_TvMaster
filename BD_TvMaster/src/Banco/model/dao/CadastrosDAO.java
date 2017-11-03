package Banco.model.dao;

import Banco.connection.ConnectionFactory;
import Banco.model.bean.Funcionario;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastrosDAO {
    
    public void create(Funcionario f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO funcionarios (nome,email,telefone,cpf,apelido,senha,privilegio) VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1,f.getNome());
            stmt.setString(2,f.getEmail());
            stmt.setString(3, f.getTelefone());
            stmt.setString(4,f.getCpf());
            stmt.setString(5,f.getApelido());
            stmt.setString(6,f.getSenha());
            stmt.setString(7,f.getPrivilegio());
 
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrosDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public List<Funcionario> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Funcionario> fun = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionarios");
            rs = stmt.executeQuery();
            
            while(rs.next()){
            
            Funcionario f = new Funcionario();
            
            f.setID(rs.getString("ID"));
            f.setNome(rs.getString("nome"));
            f.setEmail(rs.getString("email"));
            f.setTelefone(rs.getString("telefone"));
            f.setCpf(rs.getString("cpf"));
            f.setApelido(rs.getString("apelido"));
            f.setSenha(rs.getString("senha"));
            f.setPrivilegio(rs.getString("privilegio"));
            fun.add(f);
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        
        return fun;
        
    }
    
    public void update(Funcionario f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE funcionarios SET nome = ?, email = ?,telefone = ?,cpf = ?,apelido = ?,senha = ?,privilegio = ? WHERE ID = ?");
            stmt.setString(1,f.getNome());
            stmt.setString(2,f.getEmail());
            stmt.setString(3,f.getTelefone());
            stmt.setString(4,f.getCpf());
            stmt.setString(5,f.getApelido());
            stmt.setString(6,f.getSenha());
            stmt.setString(7,f.getPrivilegio());
            stmt.setString(8,f.getID());
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrosDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
          
    }
    
    public void delete(Funcionario f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM funcionarios WHERE ID = ?");
            stmt.setString(1,f.getID());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Removido com sucesso");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrosDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    
    }
}    

