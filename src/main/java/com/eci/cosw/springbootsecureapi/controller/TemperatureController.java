package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Temperature;
import com.eci.cosw.springbootsecureapi.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "api" )
public class TemperatureController {
    @Autowired
    private TemperatureService temperatureService;

    @RequestMapping( value = "/temperature", method = RequestMethod.GET )
    public List<Temperature> getTemperatures(){
        return temperatureService.getTemperatureList();

    }

    @RequestMapping( value = "/temperature", method = RequestMethod.POST )
    public Temperature setTemperature(@RequestBody Temperature temperature){
        return temperatureService.addTemperature(temperature);
    }



}
