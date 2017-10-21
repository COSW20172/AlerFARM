package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Temperature;
import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class TemperatureServiceImpl implements TemperatureService {

    private List<Temperature> todos=new ArrayList<Temperature>();

    @Autowired
    public TemperatureServiceImpl(){
        
    }

    @PostConstruct
    private void populateSampleData()
    {
        todos.add( new Temperature( 23121,365455564,54654544,54654));
        todos.add( new Temperature( 6546,3654564,54654,545465) );
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
