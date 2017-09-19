package com.eci.cosw.springbootsecureapi.model;

import java.util.Date;

public class Temperature {
    private String id ;
    private Float valor;
    private String fecha;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    

    public Temperature(){

    }

    public Temperature(String id, Float valor, String fecha,String description){
        this.setID(id);
        this.setValor(valor);
        this.setFecha(fecha);
        this.setDescription(description);
        
    }


}
