package AlertFarm.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Humedades")
public class Humidity  implements Serializable {

    private int idParametro;
    private int Clientes_idClientes;
    private double valor;
    private double fecha;
    private int Arduino_idArduino;

    @Column(name = "Arduino_idArduino", nullable = false)
    public int getArduino_idArduino() {
        return Arduino_idArduino;
    }

    public void setArduino_idArduino(int arduino_idArduino) {
        Arduino_idArduino = arduino_idArduino;
    }

    @Column(name = "Clientes_idClientes", nullable = false)
    public int getClientes_idClientes() {
        return Clientes_idClientes;
    }

    public void setClientes_idClientes(int clientes_idClientes) {
        Clientes_idClientes = clientes_idClientes;
    }

    @Id
    @Column(name = "idParametro", nullable = false)
    public int getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(int idParametro) {
        this.idParametro = idParametro;
    }

    @Column(name = "valor", nullable = false)
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Column(name = "fecha", nullable = false)
    public double getFecha() {
        return fecha;
    }

    public void setFecha(double fecha) {
        this.fecha = fecha;
    }

    public Humidity(){

    }

    public Humidity(int idParametro,int idCliente, double valor, double fecha,int Arduino_idArduino ){
        this.setIdParametro(idParametro);
        this.setClientes_idClientes(idCliente);
        this.setValor(valor);
        this.setFecha(fecha);
        this.setArduino_idArduino(Arduino_idArduino);
    }

    @Override
    public String toString()
    {
        return "Humidity{" + "idParametro=" + idParametro + ", Clientes_idClientes=" + Clientes_idClientes  + ", valor='" + valor  + ", fecha="
                + fecha + ", Arduino_idArduino=" + Arduino_idArduino +  '}';
    }


}
