package Banco.model.dao;

import Banco.connection.ConnectionFactory;
import Banco.model.bean.Canal;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CanaisDAO {
    
    public void create(Canal can){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO canais (nome,classificacao,categoria,preco) VALUES(?,?,?,?)");
            stmt.setString(1,can.getNome());
            stmt.setString(2,can.getClassificacao());
            stmt.setInt(3,can.getCategoria());
            stmt.setFloat(4,can.getPreco());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
   
        } catch (SQLException ex) {
            Logger.getLogger(CategoriasDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public List<Canal> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Canal> c = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM canais");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Canal can = new Canal();

                can.setNumero(rs.getString("numero"));
                can.setNome(rs.getString("nome"));
                can.setClassificacao(rs.getString("classificacao"));
                can.setCategoria(Integer.parseInt(rs.getString("categoria")));
                can.setPreco(Float.parseFloat(rs.getString("preco")));

                c.add(can);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        
        return c;
        
    }
    
}
