package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.UserRepository;
import java.util.List;


@Service
@Transactional
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    public void editUser(User user) {
        userRepository.editUser(user);
    }

    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

   @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUserByUsername(username);
    }

}