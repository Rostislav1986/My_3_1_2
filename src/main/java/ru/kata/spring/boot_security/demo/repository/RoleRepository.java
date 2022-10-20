package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;


@Repository
public interface RoleRepository {

    Role getRoleById(Long id);
    Role getRoleByName(String name);
    List<Role> getAllRoles();

    void addRole(Role role);
}