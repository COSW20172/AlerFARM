package AlertFarm.api.repositories;

import AlertFarm.entities.Humidity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HumidityRepository extends JpaRepository<Humidity, Integer> {

    @Query(value = "SELECT idParametro, Clientes_idClientes, Arduino_idArduino, valor, fecha " +
            "FROM `Humedades` AS h " , nativeQuery = true)
    public List<Humidity> getHumidities();

}
