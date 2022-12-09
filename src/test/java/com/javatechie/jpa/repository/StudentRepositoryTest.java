package com.javatechie.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.javatechie.jpa.entity.Course;
import com.javatechie.jpa.entity.CourseMaterial;
import com.javatechie.jpa.entity.Guardian;
import com.javatechie.jpa.entity.Student;
import com.javatechie.jpa.entity.Teacher;

@SpringBootTest
//@DataJdbcTest if this is enable Database will not be impacted
class StudentRepositoryTest {
	
	@Autowired
	StudentRepository repo;
	
	@Autowired
	CourseMaterialRepository courseMaterailRepo;
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	TeacherRepository teacherRepo;
	

	@Test
	void testSaveAllIterableOfS() {
		
		
		  Guardian gru=Guardian.builder() .email("guardian@gmail.com")
		  .mobile("9834466575") .name("bbbbb") .build(); Student st=Student.builder()
		  .emailId("Rakesh@gmail.com") .firstName("Debashish") .lastName("Mahato")
		  .guardian(gru) .build(); repo.save(st);
		 
		 
		
		
	}
	
	@Test
	void testGetStudentByFisrtName() {
		
		
		List<Student> list=repo.findByGuardianName("bbbbb");
		Student st=repo.getStudentByEmailid("Rakesh@gmail.com");
		System.out.println(list);
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		System.out.println(st);
		
		System.out.println("##########################################");
		
		System.out.println(repo.getStudentFirstNameByEmailid("Rakesh@gmail.com"));
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(repo.getStudentByEmailAddressNative("Rakesh@gmail.com").getFirstName());
		System.out.println("*******************************************************");
		System.out.println(repo.getStudentByGurdianMailAndMobileNumberNative("kaaaaad@gmail.com", "9834466575"));
		
		Student stt=repo.getStudentByemailIdAndGuradianMailId("Rakesh@gmail.com","kaaaaad@gmail.com" );
		
		System.out.println(stt);
		
		/*
		 * List<Student> list=repo.findByFirstName("Debashish"); List<Student>
		 * list2=repo.findByFirstNameAndLastName("Rajesh","Mahato");
		 * System.out.println(list);
		 * System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		 * System.out.println(list2);
		 */
		/*
		 * System.out.println("########################################"); List<Student>
		 * list3=repo.findByGuardianName("Pramod");
		 */
		
	}
	
	@Test
	void updateData() {
		int no=repo.updateStudentByGurdianMailId("Birjesh@gmail.com", "guardian@gmail.com");
		System.out.println(no);
	}

	@Test
	void oneToOneMappingTest() {
		
		Course course=Course.builder()
				.creadit(20)
				.title("Java complete Reffreence")
				.build();
		
		CourseMaterial material=CourseMaterial.builder()
				.url("www.java.com")
				.course(course)
				.build();
		courseMaterailRepo.save(material);
	}
	
	@Test
	void fetchTypeTest() {
		
		List<CourseMaterial> material=courseMaterailRepo.findAll();
		//System.out.println(material);
		
		for(CourseMaterial arr:material) {
			System.out.println(arr.getUrl());
			System.out.println(arr.getMaterialId());
			try {
				System.out.println(arr.getCourse().getTitle());
			}catch(Exception es) {
				es.printStackTrace();
			}
		}
	}
	
	@Test
	void fetchCourse() {
		System.out.println(courseRepo.findAll());
	}
	
	@Test
	void saveTeacheAndCourse() {
	
		Course course1=Course.builder()
				.creadit(20)
				.title("Java")
				.build();
		
		Course course2=Course.builder()
				.creadit(30)
				.title("C++")
				.build();
		
		Course course3=Course.builder()
				.creadit(50)
				.title("DBMS")
				.build();
		
		List<Course> course=new ArrayList<Course>();
		course.add(course1);
		course.add(course2);
		course.add(course3);
		
		Teacher teacher=Teacher.builder()
						.firstName("Pratap")
						.lastName("Mishra")
					//	.course(course)
						.build();
		teacherRepo.save(teacher);
						
		
	}
	
	@Test
	void manyToOne() {
		
		Teacher teacher=Teacher.builder()
						.firstName("Rajesh")
						.lastName("Sharma")
						.build();
		Course course1=Course.builder()
				.creadit(20)
				.title("English")
				.teacher(teacher)
				.build();
		Course course2=Course.builder()
				.creadit(40)
				.title("Maths")
				.teacher(teacher)
				.build();
		
		Course course3=Course.builder()
				.creadit(30)
				.title("History")
				.teacher(teacher)
				.build();
		
		//List<Course> list=List.of(course1, course2, course3);
		
		//courseRepo.saveAll(list);
	}
}
