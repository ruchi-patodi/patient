package com.example.patient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.model.Patient;
import com.example.repository.PatientRepository;

@SpringBootApplication
@ComponentScan("com.example")
@EnableJpaRepositories("com.example")
@EntityScan("com.example.model") 
public class PatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientApplication.class, args);
	}
	
	@Bean
	public  CommandLineRunner patientDemo(PatientRepository patientRepository) {
		
		return (args)->{
			
			patientRepository.save(new Patient("Aria", "Geller", "female", "starhollow", "L_8974"));
			
			
		};
	}
}
