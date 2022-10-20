package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@SpringBootApplication
@Component
public class Application implements ApplicationRunner {
	private UserService userService;
	private BCryptPasswordEncoder passwordEncoder;
	private RoleService roleService;
	@Autowired
	public Application(UserService userService, BCryptPasswordEncoder passwordEncoder,RoleService roleService) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
        this.roleService =roleService;
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<User> users = userService.getAllUsers();

		if (users.isEmpty()) {
			roleService.addRole(new Role("ROLE_ADMIN"));
			roleService.addRole(new Role("ROLE_USER"));
			Role admin = roleService.getRoleById(1L);
			Role user = roleService.getRoleById(2L);
			Set<Role> adminRole = new HashSet<>();
			Set<Role> userRole = new HashSet<>();
			adminRole.add(admin);
			userRole.add(user);
			userService.addUser(new User("Rostislav", "Adminov", 36, "admin", passwordEncoder.encode("admin"), adminRole));
			userService.addUser(new User("Oleg", "Popov", 24, "Oleg98", passwordEncoder.encode("user1"), userRole));
			userService.addUser(new User("Kostya", "Mosenkov", 36, "Kostya86", passwordEncoder.encode("user2"), userRole));
			userService.addUser(new User("Marat", "Achilov", 33, "Marik", passwordEncoder.encode("user3"), userRole));
			userService.addUser(new User("Maksim", "Sinyavskiy", 34, "Makson", passwordEncoder.encode("user4"), userRole));


		}
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}