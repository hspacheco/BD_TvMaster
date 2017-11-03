package Banco.model.dao;

import Banco.connection.ConnectionFactory;
import Banco.model.bean.Cliente;
import Banco.model.bean.Contrato;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ContratosDAO {
    
    
    public void create(Contrato c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO contratos (receptores,endereco,plano,clienteId) VALUES(?,?,?,?)");
            stmt.setInt(1,c.getReceptores());
            stmt.setString(2,c.getEndereco());
            stmt.setInt(3,c.getPlano());
            stmt.setInt(4,c.getClienteID());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
         
        } catch (SQLException ex) {
            Logger.getLogger(ContratosDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public List<Cliente> readCliente(String nome){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> fun = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM clientes WHERE nome LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
            
                Cliente c = new Cliente();

                c.setID(rs.getString("ID"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
        
                fun.add(c);
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        
        return fun;
        
    }
    
    
}
