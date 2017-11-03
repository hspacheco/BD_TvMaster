package Banco.model.dao;

import Banco.connection.ConnectionFactory;
import Banco.model.bean.Plano;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PlanosDAO {
    
    public void create(Plano p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO planos (nome) VALUES(?)");
            stmt.setString(1,p.getNome());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
   
        } catch (SQLException ex) {
            Logger.getLogger(PlanosDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
     public List<Plano> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Plano> c = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM planos");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Plano p = new Plano();

                p.setID(rs.getString("ID"));
                p.setNome(rs.getString("nome"));
                
                c.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        
        return c;
        
    }
    
}
