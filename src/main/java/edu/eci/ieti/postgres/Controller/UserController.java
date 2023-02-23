package edu.eci.ieti.postgres.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.postgres.UserNotFoundException;
import edu.eci.ieti.postgres.Model.User;
import edu.eci.ieti.postgres.Model.UserDto;
import edu.eci.ieti.postgres.Repository.UserRepository;

@RestController
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/usuarios")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public User findById(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()){
                return optionalUser.get();
            } 
            else {
                throw new UserNotFoundException();
            }
    }

    @PostMapping("/addUser")
    public User createUser(UserDto userDto) {
            User user = new User(userDto);
            return userRepository.save(user);
    }

}
