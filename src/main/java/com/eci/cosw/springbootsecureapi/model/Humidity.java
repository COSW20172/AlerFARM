package com.eci.cosw.springbootsecureapi.model;

public class Humidity {
    private int idParametro ;
    private int Clientes_idClientes;
    private Float valor;
    private Float fecha;

    public Humidity(int idParametro, int clientes_idClientes, int i, int i1) {

    }

    public int getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(int idParametro) {
        this.idParametro = idParametro;
    }

    public int getClientes_idClientes() {
        return Clientes_idClientes;
    }

    public void setClientes_idClientes(int clientes_idClientes) {
        Clientes_idClientes = clientes_idClientes;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Float getFecha() {
        return fecha;
    }

    public void setFecha(Float fecha) {
        this.fecha = fecha;
    }

    public Humidity(){

    }
    
    

    public Humidity(int idParametro,int Clientes_idClientes, Float valor, Float fecha){
        this.idParametro=(idParametro);
        this.valor=(valor);
        this.fecha=(fecha);
        this.Clientes_idClientes=(Clientes_idClientes);
        
    }


}
