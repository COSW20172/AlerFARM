package AlertFarm.api.repositories;

import AlertFarm.entities.Humidity;
import AlertFarm.entities.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {


    @Query(value = "SELECT idParametro, Clientes_idClientes, Arduino_idArduino, valor, fecha " +
            "FROM `Temperaturas` AS h " , nativeQuery = true)
    public List<Temperature> getTemperatures();
}
