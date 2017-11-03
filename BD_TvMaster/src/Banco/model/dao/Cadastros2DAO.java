package Banco.model.dao;

import Banco.connection.ConnectionFactory;
import Banco.model.bean.Cliente;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cadastros2DAO {
    
    public void create(Cliente c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO clientes (nome,email,telefone,cpf) VALUES(?,?,?,?)");
            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getEmail());
            stmt.setString(3,c.getTelefone());
            stmt.setString(4,c.getCpf());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Cadastros2DAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public List<Cliente> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> fun = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM clientes");
            rs = stmt.executeQuery();
            
            while(rs.next()){
            
            Cliente c = new Cliente();
            
            c.setID(rs.getString("ID"));
            c.setNome(rs.getString("nome"));
            c.setEmail(rs.getString("email"));
            c.setTelefone(rs.getString("telefone"));
            c.setCpf(rs.getString("cpf"));
            fun.add(c);
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        
        return fun;
        
    }
    
    public void update(Cliente c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE clientes SET nome = ?, email = ?,telefone = ?,cpf = ? WHERE ID = ?");
            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getEmail());
            stmt.setString(3,c.getTelefone());
            stmt.setString(4,c.getCpf());
            stmt.setString(5,c.getID());
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Cadastros2DAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
          
    }
    
    public void delete(Cliente c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM clientes WHERE ID = ?");
            stmt.setString(1,c.getID());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Removido com sucesso");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Cadastros2DAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    
    }
}    