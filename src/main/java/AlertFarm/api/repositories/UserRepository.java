package AlertFarm.api.repositories;

import AlertFarm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {


    @Query(value = "SELECT idClientes, correo, password, name, celular " +
            "FROM `clientes` AS h " , nativeQuery = true)
    public List<User> getUsers();
}
