package AlertFarm.api.persistence;

import AlertFarm.entities.Temperature;

import java.util.List;

public interface TemperaturePersistence {

    public List<Temperature> getTemperatures();
}
