package com.eci.cosw.springbootsecureapi.model;

import java.util.Date;

public class Humidity {
    private String id ;
    private Float valor;
    private Float fecha;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return id;
    }

    public void setID(String ID) {
        this.id = ID;
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

    public Humidity(String id, Float valor, Float fecha,String description){
        this.setID(id);
        this.setValor(valor);
        this.setFecha(fecha);
        this.setDescription(description);
        
    }


}
