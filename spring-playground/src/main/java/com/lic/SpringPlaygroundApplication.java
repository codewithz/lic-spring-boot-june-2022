package com.lic;

import com.lic.model.Student;
import com.lic.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

@SpringBootApplication
public class SpringPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPlaygroundApplication.class, args);
		System.out.println("Test-LIC");

	}
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository){
		return args -> {

			Student tom=new Student(
					"Tom","Smith",
					"tom.smith@gmail.com",23);
			System.out.println("Saving Tom");
			repository.save(tom);

			Student alex=new Student("Alex","Holmes",
					"alex.holmes@gmail.com",21);

			Student mike=new Student("Mike","Porter",
					"mike.porter@gmail.com",25);

			System.out.println("Saving Mike and Alex");

			repository.saveAll(List.of(mike,alex));


		};
	}

}
