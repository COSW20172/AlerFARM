package com.eci.cosw.springbootsecureapi.model;

import java.util.Date;

public class Temperature {
    private int idParametro ;
    private int Clientes_idClientes;
    private Float valor;
    private Float fecha;

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

    public Temperature(int idParametro, int clientes_idClientes, float i, float i1){
        this.idParametro=(idParametro);
        this.valor=(i);
        this.fecha=(i1);
        this.Clientes_idClientes=(Clientes_idClientes);
    }

    public Temperature(int idParametro,int Clientes_idClientes, Float valor, Float fecha){
        this.setIdParametro(idParametro);
        this.setValor(valor);
        this.setFecha(fecha);
        this.setClientes_idClientes(Clientes_idClientes);

    }


}
