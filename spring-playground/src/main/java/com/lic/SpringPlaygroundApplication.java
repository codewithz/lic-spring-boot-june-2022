package com.lic;

import com.github.javafaker.Faker;
import com.lic.model.Book;
import com.lic.model.Student;
import com.lic.model.StudentIdCard;
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
	CommandLineRunner commandLineRunner(StudentRepository studentRepository,
										StudentIdCardRepository studentIdCardRepository){
		return args -> {
			Faker faker=new Faker();


			String firstName=faker.name().firstName();
			String lastName=faker.name().lastName();
			String email=String.format("%s.%s@gmail.com",firstName,lastName);
			int age=faker.number().numberBetween(18,60);

			System.out.println("-------Saving Student ------------");
			Student student=new Student(firstName,lastName,email,age);

			StudentIdCard studentIdCard=new StudentIdCard("123456789",student);

			Book book1=new Book("Clean Code", LocalDateTime.now().minusDays(4));
			Book book2=new Book("Head First Java",LocalDateTime.now());
			Book book3=new Book("Master Spring Data JPA",LocalDateTime.now().minusMonths(6));

			student.setStudentIdCard(studentIdCard);

			student.addBook(book1);
			student.addBook(book2);
			student.addBook(book3);

			studentRepository.save(student);

			System.out.println("----------- Fetch the student object----------------");

			studentRepository.findById(1L).ifPresent(student1 -> {
				System.out.println("Lazy Loading of Books.......");
				List<Book> books=student1.getBooks();
				books.forEach(b->{
					System.out.println(b.getBookName()+"-"+b.getCreatedAt());
				});
			});



		};
	}

	private void testOneToOneMapping(StudentRepository studentRepository,StudentIdCardRepository studentIdCardRepository){
		Faker faker=new Faker();


		String firstName=faker.name().firstName();
		String lastName=faker.name().lastName();
		String email=String.format("%s.%s@gmail.com",firstName,lastName);
		int age=faker.number().numberBetween(18,60);
		Student student=new Student(firstName,lastName,email,age);

		StudentIdCard studentIdCard=new StudentIdCard("123456789",student);

		System.out.println("Saving the Student with an Id Card");

		student.setStudentIdCard(studentIdCard);
		studentRepository.save(student);
//			studentIdCardRepository.save(studentIdCard);

		System.out.println("--- Fetching the Student Id Card Record ---------");

		studentIdCardRepository.findById(1L).
				ifPresent(System.out::println);


		System.out.println("------------------Fetching Student Id---------------------");

		studentRepository.findById(1L)
				.ifPresent(student1 -> {
					System.out.println(student1);
					System.out.println(student1.getStudentIdCard());
				});

		System.out.println("------------ Deleting Student--------------");
		studentRepository.deleteById(1L);


	}
	private void generateRandomStudents(StudentRepository repository){
		Faker faker=new Faker();

		for (int i=1;i<=300;i++){
			String firstName=faker.name().firstName();
			String lastName=faker.name().lastName();
			String email=String.format("%s.%s@gmail.com",firstName,lastName);
			int age=faker.number().numberBetween(18,60);
			Student s=new Student(firstName,lastName,email,age);
			repository.save(s);
		}
	}

	private void sorting(StudentRepository repository){
		Sort sort=Sort.by("firstName").ascending()
						.and(Sort.by("age").descending());

		repository.findAll(sort)
				.forEach(student -> System.out.println(student.getFirstName()+"--"+student.getAge()));
	}

	private void jpaBasicQueries(StudentRepository repository){
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

		System.out.println("------------------------------Custom Queries-------------------------");

		repository.findStudentByEmail("thomas.smith@gmail.com")
				.ifPresentOrElse(
						System.out::println,
						()-> System.out.println("Not Found")
				);

		System.out.println("-----------------------------------------");

		List<Student> list=repository.
				findStudentsByFirstNameAndAgeGreaterThanEqual("Alex",21);

		list.forEach(System.out::println);

		System.out.println("-----------------------------------------");

		List<Student> list1=repository.
				findStudentsByFirstNameOrAgeGreaterThanEqual("Alex",21);

		list1.forEach(System.out::println);

		System.out.println("----------- QUERIES----------------------------");
		repository.selectStudentByEmail("alex.holmes@gmail.com")
				.ifPresentOrElse(
						System.out::println,
						()-> System.out.println("Not Found")
				);

	}

}
