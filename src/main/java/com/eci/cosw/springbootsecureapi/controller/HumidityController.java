package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Humidity;
import com.eci.cosw.springbootsecureapi.service.HumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "api" )
public class HumidityController {
    @Autowired
    private HumidityService humidityService;

    @RequestMapping( value = "/humidity", method = RequestMethod.GET )
    public List<Humidity> getHumiditys(){
        return humidityService.getHumidityList();

    }

    @RequestMapping( value = "/humidity", method = RequestMethod.POST )
    public Humidity setHumidity(@RequestBody Humidity humidity){

        return humidityService.addHumidity(humidity);
    }



}
