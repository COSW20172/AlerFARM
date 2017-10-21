package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Humidity;
import com.eci.cosw.springbootsecureapi.model.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class HumidityServiceImpl implements HumidityService {

    private List<Humidity> todos=new ArrayList<Humidity>();

    @Autowired
    public HumidityServiceImpl(){
        
    }

    @PostConstruct
    private void populateSampleData()
    {
        todos.add( new Humidity( 23121,3654564,54654,54654));
        todos.add( new Humidity( 6546,3654564,54654,545465) );
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
