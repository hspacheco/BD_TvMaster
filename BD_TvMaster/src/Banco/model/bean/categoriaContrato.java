
package Banco.model.bean;

/**
 *
 * @author Pacheco's
 * Essa classe serve como intermediária entre os Contratos e as categorias, armazenando para poder saber quantos 
 * contratos o cliente fez.
 */
public class categoriaContrato {
    private int numContrato;
    private int idCategoria;
    private int idCliente;

    public int getNumContrato() {
        return numContrato;
    }

    public void setNumContrato(int numContrato) {
        this.numContrato = numContrato;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
}
