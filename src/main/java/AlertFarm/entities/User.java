package AlertFarm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Entity
@Table(name = "Clientes")
public class User implements Serializable
{

    private int idUser;

    private String email;

    private String password;

    private String name;

    private String celular;

    public User()
    {
    }

    public User( String email, String password, String name,int idUser,String celular )
    {
        this.idUser = idUser;
        this.email = email;
        this.password = password;
        this.name = name;
        this.celular = celular;
    }

    @Id
    @Column(name = "idClientes", nullable = false)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Column(name = "correo", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "celular", nullable = false)
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }


    @Override
    public String toString()
    {
        return "User{" + "id=" + idUser + ", email='" + email + '\'' + ", password='" + password + '\'' + ", name='"
            + name + ", celular='" + celular + '\'' + '}';
    }

}
