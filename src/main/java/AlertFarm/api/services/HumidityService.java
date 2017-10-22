package AlertFarm.api.services;

import AlertFarm.entities.Humidity;

import java.util.List;

public interface HumidityService {

    List<Humidity> getHumidityList() throws ServicesException;
    Humidity addHumidity( Humidity humidity );
}
