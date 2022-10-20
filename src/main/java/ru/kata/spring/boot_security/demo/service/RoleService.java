package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;

import java.util.List;

@Service
@Transactional
public class RoleService {
    private RoleRepository roleRepository;
    @Autowired
    public RoleService (RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }
    public void addRole(Role role) {
        roleRepository.addRole(role);
    }
@Transactional
    public List<Role> getAllRoles() {
        return roleRepository.getAllRoles();
    }
    @Transactional(readOnly=true)
    public Role getRoleById(Long id) {
        return roleRepository.getRoleById(id);
    }
    @Transactional(readOnly = true)
    public Role getRoleByName(String name) {
        return roleRepository.getRoleByName(name);
    }


}
