# lic-spring-boot-june-2022

<img width="804" alt="jpa-1" src="https://user-images.githubusercontent.com/71726246/174946290-4a4fbb15-c6f0-4207-b133-069ee9e9931a.PNG">


<img width="899" alt="jpa-2" src="https://user-images.githubusercontent.com/71726246/174946321-26ab9166-43ac-4f00-aa19-a5bee4d1075c.PNG">

**CascadeType.PERSIST**: When persisting an entity, also persist the entities held in its fields. We suggest a liberal application of this cascade rule, because if the EntityManager finds a field that references a new entity during the flush, and the field does not use CascadeType.PERSIST, it is an error.

**CascadeType.REMOVE**: When deleting an entity, it also deletes the entities held in this field.

**CascadeType.REFRESH:** When refreshing an entity, also refresh the entities held in this field.

**CascadeType.MERGE:** When merging entity state, also merge the entities held in this field.


**Task for Day 5 **

1. Create an API to store the book.
2. Create an API to update and delete a book
3. Create an API to get all books in the database.
4. Create an API to get the list of books which are allocated to Student at id 9, if there are no books throw an exception not found 
5. Create an API to load the student details with the Student ID card.
6. Create an API to get the list of courses applied by student 4
7. Create an API to get the list of students who have applied for the course where the course id is 10
8. Create the following structure using Spring Data JPA

![image](https://user-images.githubusercontent.com/71726246/175362569-f33f83e9-5905-4598-a542-dd32103f6b58.png)

