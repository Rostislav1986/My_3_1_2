package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
	private RoleService roleService;
	@Autowired
	public Application(UserService userService,RoleService roleService) {
		this.userService = userService;
        this.roleService =roleService;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<User> users = userService.getAllUsers();

		if (users.isEmpty()) {
			Role admin = new Role("ROLE_ADMIN");
			Role user = new Role("ROLE_USER");
			roleService.addRole(admin);
			roleService.addRole(user);
			Set<Role> adminRole = new HashSet<>();
			adminRole.add(admin);
			adminRole.add(user);
			userService.addUser(new User("Rostislav", "Adminov", 36, "admin","admin", adminRole));
			userService.addUser(new User("Oleg", "Popov", 24, "Oleg98", "user1"));
			userService.addUser(new User("Kostya", "Mosenkov", 36, "Kostya86", "user2"));
			userService.addUser(new User("Marat", "Achilov", 33, "Marik", "user3"));
			userService.addUser(new User("Maksim", "Sinyavskiy", 34, "Makson","user4"));
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}