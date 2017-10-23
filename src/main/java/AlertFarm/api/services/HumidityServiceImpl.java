package AlertFarm.api.services;

import AlertFarm.api.repositories.HumidityRepository;
import AlertFarm.entities.Humidity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HumidityServiceImpl implements HumidityService {

    private List<Humidity> todos=new ArrayList<Humidity>();
    @Autowired
    private HumidityRepository humrepo;

    @Override
    public List<Humidity> getHumidityList() throws ServicesException {
        todos=humrepo.getHumidities();
        System.out.print(todos.get(0).getArduino_idArduino());
        return todos;
    }

    @Override
    public Humidity addHumidity(Humidity humidity) {
        todos.add(humidity);
        return (humidity);
    }
}
