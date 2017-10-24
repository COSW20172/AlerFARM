package AlertFarm.api.services;

import AlertFarm.api.repositories.TemperatureRepository;

import AlertFarm.entities.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemperatureServiceImpl implements TemperatureService {

    private List<Temperature> todos=new ArrayList<Temperature>();
    @Autowired
    private TemperatureRepository temrepo;

    @Override
    public List<Temperature> getTemperatureList() throws ServicesException {
        todos= temrepo.getTemperatures();
        return todos;
    }

    @Override
    public Temperature addTemperature(Temperature temperature) {
        todos.add(temperature);
        return (temperature);
    }
}
