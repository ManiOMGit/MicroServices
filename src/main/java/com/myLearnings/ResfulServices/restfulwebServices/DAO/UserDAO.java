package com.myLearnings.ResfulServices.restfulwebServices.DAO;

import com.myLearnings.ResfulServices.restfulwebServices.Entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDAO {
    private static List<User> users=new ArrayList<>();
    static{
        users.add(new User("mani1",25,new Date()));
        users.add(new User("mani2",24,new Date()));
        users.add(new User("mani3",22,new Date()));
    }
    public List<User> findALl(){
        return users;
    }
    public User save(User usr){
        users.add(usr);
        return usr;
    }
    public User findById(int id){
        for(User usr1:users){
            if(usr1.getAge()==id)
                return usr1;
        }
        return null;
    }

}
