package com.myLearnings.ResfulServices.restfulwebServices.Controllers;

import com.myLearnings.ResfulServices.restfulwebServices.DAO.UserDAO;
import com.myLearnings.ResfulServices.restfulwebServices.Entity.User;
import com.myLearnings.ResfulServices.restfulwebServices.Exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private UserDAO userDAO;
    @Autowired
    UserController(UserDAO userDAO){
        this.userDAO=userDAO;
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userDAO.findALl();
    }
    @GetMapping("user/{id}")
    public User getUserById(@PathVariable int id)  {
        User user1=userDAO.findById(id);
        if(user1==null){
            throw new UserNotFoundException("id-"+id);
        }
        return userDAO.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user){

        User user1=userDAO.save(user);
      URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{d}").buildAndExpand(user1.getAge()).toUri();
      return ResponseEntity.created(location).build();
       // return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

}
