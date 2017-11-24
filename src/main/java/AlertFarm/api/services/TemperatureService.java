package AlertFarm.api.services;

import AlertFarm.entities.Temperature;

import java.util.List;

public interface TemperatureService {

    List<Temperature> getTemperatureListId(String id) throws ServicesException;
    List<Temperature> getTemperatureList() throws ServicesException;
    Temperature addTemperature( Temperature temperature );
}
