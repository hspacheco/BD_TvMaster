package Banco.model.bean;


public class Contrato {
    
    private String numero;
    private int receptores;
    private String endereco;
    private int plano;
    private int clienteID;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getReceptores() {
        return receptores;
    }

    public void setReceptores(int receptores) {
        this.receptores = receptores;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getPlano() {
        return plano;
    }

    public void setPlano(int plano) {
        this.plano = plano;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }
    
  
}
