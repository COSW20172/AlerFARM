package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Service
public class UserServiceImpl
    implements UserService
{

    private List<User> users = new ArrayList<>();


    @Autowired
    public UserServiceImpl()
    {
    }

    @PostConstruct
    private void populateSampleData()
    {
        users.add( new User( "test@mail.com","password","juan diaz",01,"+573015669878"));
        users.add( new User( "test@mail2.com","password2","juan dos diaz",02,"+573025669878") );
    }


    @Override
    public List<User> getUsers(){
        return users;
    }

    @Override
    public User getUser( Long id )
    {
        return users.get( 0 );
    }

    @Override
    public User createUser( User user )
    {
        return users.get( 0 );
    }

    @Override
    public User findUserByEmail( String email )
    {
        return users.get( 0 );
    }

    @Override
    public User findUserByEmailAndPassword( String email, String password )
    {
        User temp=users.get( 0 );
        for(int i=0;i<users.size();i+=1)
        {
            if ((email.equals(users.get(i).getEmail())) && (password.equals(users.get(i).getPassword()))){
                temp=users.get(i);
            }
        }
        System.out.println(users);
        return temp;
    }

    @Override
    public User registerUser(User user) {
        users.add(user);
        return (user);

    }


}
