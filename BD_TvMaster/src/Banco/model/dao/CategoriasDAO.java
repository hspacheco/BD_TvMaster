package Banco.model.dao;

import Banco.connection.ConnectionFactory;
import Banco.model.bean.Categoria;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CategoriasDAO {
    
    public void create(Categoria cat){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO categorias (nome) VALUES(?)");
            stmt.setString(1,cat.getNome());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
   
        } catch (SQLException ex) {
            Logger.getLogger(CategoriasDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public List<Categoria> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Categoria> c = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM categorias");
            rs = stmt.executeQuery();
            
            while(rs.next()){
            
                Categoria cat = new Categoria();

                cat.setID(rs.getString("ID"));
                cat.setNome(rs.getString("nome"));
                c.add(cat);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        
        return c;
        
    }
    
    
}
