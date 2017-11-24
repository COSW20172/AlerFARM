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


    @Query(value = "SELECT idParametro, Clientes_idClientes, Arduino_idArduino, valor, fecha " +
            "FROM `Clientes` AS c,`Humedades` AS h " +
            "WHERE h.Clientes_idClientes = c.idClientes AND " +
            "((SELECT MAX(idParametro) FROM `Humedades`) - 50) <= h.idParametro AND " +
            "c.correo =?1", nativeQuery = true)
    public List<Humidity> getHumiditiesId(@Param(value = "id")String id);


}
