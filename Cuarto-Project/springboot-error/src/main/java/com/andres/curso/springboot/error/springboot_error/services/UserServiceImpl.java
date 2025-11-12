package com.andres.curso.springboot.error.springboot_error.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.andres.curso.springboot.error.springboot_error.models.domain.User;

@Service
public class UserServiceImpl implements UserService{

    private List<User> users;

    public UserServiceImpl(){
        this.users=new ArrayList<>();
        users.add(new User(1L,"Pepe","Gonzales"));
        users.add(new User(2L,"Andres","Mensa"));
        users.add(new User(3L,"Maria","Perez"));
        users.add(new User(4L,"Josefa","Reamirez"));
        users.add(new User(5L,"Ale","Gutierrez"));
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User>  findById(Long id) {
        User user = null;
        for(User u:users){
            /* Interaccion de todo el map cuando verifica hace break */
            if(u.getId().equals(id)){
                user=u;
                break;
            }
        }
        if(user==null){
            return Optional.empty();
        }
       /*  return user; */
       return Optional.ofNullable(user);
    }
    
}
