package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Temperature;

import java.util.List;

public interface TemperatureService {
    List<Temperature> getTemperatureList();
    Temperature addTemperature( Temperature temperature );
}
