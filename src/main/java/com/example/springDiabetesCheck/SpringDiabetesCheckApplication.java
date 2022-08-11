package com.example.springDiabetesCheck;

import java.util.ArrayList;
import com.example.springDiabetesCheck.domain.Role;
import com.example.springDiabetesCheck.domain.User;
import com.example.springDiabetesCheck.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDiabetesCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDiabetesCheckApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	/*@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User(null, "Isabela Cristina", "isabela", "1234", new ArrayList<>()));
			userService.addRouleToUser("isabela", "ROLE_ADMIN");
			userService.addRouleToUser("isabela", "ROLE_USER");

			userService.saveUser(new User(null, "Maria", "maria", "1234", new ArrayList<>()));
			userService.addRouleToUser("maria", "ROLE_USER");

			userService.saveUser(new User(null, "Joao", "joao", "1234", new ArrayList<>()));
			userService.addRouleToUser("joao", "ROLE_USER");


			//userService.saveRole(new Role(null, "ROLE_MANAGER"));
			//userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
			//userService.saveUser(new User(null, "Will Smith", "will", "1234", new ArrayList<>()));
			//userService.saveUser(new User(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
			//userService.saveUser(new User(null, "Arnold S", "arnold", "1234", new ArrayList<>()));
			//userService.addRouleToUser("isabela", "ROLE_USER");
			//userService.addRouleToUser("john", "ROLE_MANAGER");
			//userService.addRouleToUser("will", "ROLE_MANAGER");
			//userService.addRouleToUser("jim", "ROLE_ADMIN");
			//userService.addRouleToUser("arnold", "ROLE_SUPER_ADMIN");
			//userService.addRouleToUser("arnold", "ROLE_ADMIN");
			//userService.addRouleToUser("arnold", "ROLE_USER");
		};
	}*/
}
