package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Humidity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HumidityServiceImpl implements HumidityService {

    private List<Humidity> todos=new ArrayList<Humidity>();

    @Autowired
    public HumidityServiceImpl(){
        
    }

    @Override
    public List<Humidity> getHumidityList() {
        return todos;
    }

    @Override
    public Humidity addHumidity(Humidity humidity) {
        todos.add(humidity);
        return (humidity);
    }
}
