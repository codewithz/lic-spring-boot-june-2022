package com.lic;

import com.github.javafaker.Faker;
import com.lic.model.*;
import com.lic.repository.AppUserRepository;
import com.lic.repository.CourseRepository;
import com.lic.repository.StudentIdCardRepository;
import com.lic.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPlaygroundApplication.class, args);
		System.out.println("Test-LIC");

	}

	@Bean
	CommandLineRunner commandLineRunner(AppUserRepository appUserRepository){
		return args -> {

			AppUser user1=new AppUser("codewithz",
					"$2a$12$uu6gNkfj4n0OTFZ1dXC3VuG2FMSW/4S19TqQCSTGrBDIVkWm3wp7i",
					"USER");

			appUserRepository.save(user1);

			AppUser user2=new AppUser("admin",
					"$2a$12$20agn2jCwNunVyXyGs8rg.0ZdQVJiuVAvqL3AFuCBe94ptgfM0fgu",
					"ADMIN");

			appUserRepository.save(user2);



		};
	}
}