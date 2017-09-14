package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Humidity;

import java.util.List;

public interface HumidityService {
    List<Humidity> getHumidityList();
    Humidity addHumidity( Humidity humidity );
}
