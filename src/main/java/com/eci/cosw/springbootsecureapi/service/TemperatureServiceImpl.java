package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemperatureServiceImpl implements TemperatureService {

    private List<Temperature> todos=new ArrayList<Temperature>();

    @Autowired
    public TemperatureServiceImpl(){
        
    }

    @Override
    public List<Temperature> getTemperatureList() {
        return todos;
    }

    @Override
    public Temperature addTemperature(Temperature temperature) {
        todos.add(temperature);
        return (temperature);
    }
}
