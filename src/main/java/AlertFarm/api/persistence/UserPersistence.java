package AlertFarm.api.persistence;

import AlertFarm.entities.User;

public interface UserPersistence {

    public User getUser(int idCliente);

    public boolean addUser(User user);
}
