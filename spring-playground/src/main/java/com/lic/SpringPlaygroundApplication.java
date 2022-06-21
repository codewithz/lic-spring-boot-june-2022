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
import java.util.Optional;

@SpringBootApplication
public class SpringPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPlaygroundApplication.class, args);
		System.out.println("Test-LIC");

	}
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository){
		return args -> {

			Student tom = new Student(
					"Tom", "Smith",
					"tom.smith@gmail.com", 23);
			System.out.println("Saving Tom");
			repository.save(tom);

			Student alex = new Student("Alex", "Holmes",
					"alex.holmes@gmail.com", 21);

			Student mike = new Student("Mike", "Porter",
					"mike.porter@gmail.com", 25);

			System.out.println("Saving Mike and Alex");

			repository.saveAll(List.of(mike, alex));
			System.out.println("-------------------------------------------------");
			System.out.println("Number of students: " + repository.count());
			System.out.println("-------------------------------------------------");
			Optional<Student> optional = repository.findById(2L);

			if (optional.isPresent()) {
				System.out.println(optional.get());
			}
			System.out.println("-------------------------------------------------");
			repository.findById(1L)
					.ifPresentOrElse(
							System.out::println,
							() -> System.out.println("Student with id 1 is not found")
					);
			System.out.println("-------------------------------------------------");
			repository.findById(5L)
					.ifPresentOrElse(
							System.out::println,
							() -> System.out.println("Student with id 5 is not found")
					);

			System.out.println("-------------------------------------------------");

			List<Student> students = repository.findAll();
			students.forEach(System.out::println);

			System.out.println("-------------------------------------------------");

			System.out.println("--- Updating Tom-----");

			Optional<Student> optional1 = repository.findById(1L);
			if (optional1.isPresent()) {
				Student tomCopy = optional1.get();
				System.out.println(tomCopy);

				tomCopy.setFirstName("Thomas");
				tomCopy.setEmail("thomas.smith@gmail.com");

				repository.save(tomCopy);
			}

		};
	}

}
