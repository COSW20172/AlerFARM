package AlertFarm.api.persistence;

import AlertFarm.entities.Humidity;

import java.util.List;

public interface HumidityPersistence {

    public List<Humidity> getHumidities();

}
