package com.javatechie.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javatechie.jpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	public List<Student> findByGuardianName(String gurdianName);
	
	@Query("select distinct s from Student s where s.emailId=?1")
	public Student getStudentByEmailid(String emailId);
	
	/*
	 * public List<Student> findByFirstName(String firstName);
	 * 
	 * public List<Student> findByFirstNameContaining(String name);
	 * 
	 * public List<Student> findByFirstNameAndLastName(String firstName,String
	 * lastName);
	 * 
	 * public List<Student> findByLastNameNotNull(String lastName);
	 */
	
//	public List<Student> findByGuardianName(String gurdianName);
	
	@Query("select s.firstName from Student s where s.emailId=?1")
	public String getStudentFirstNameByEmailid(String emailId); 
	
	//Native Query
	@Query(
		value = "SELECT * from tbl_student s where s.email_address = ?1",
		nativeQuery = true
			)
	public Student getStudentByEmailAddressNative(String emailId);
	
	//Native Named Parameter
	@Query(
			value = "SELECT * from tbl_student s where s.gurdian_email = :gurdian_email and s.gurdian_mobile=:gurdian_mobile",
			nativeQuery = true
				)
		public Student getStudentByGurdianMailAndMobileNumberNative(@Param("gurdian_email") String email,@Param("gurdian_mobile") String mobile);
	
	//JPQL with NamedQuery
	
	@Query("select s from Student s where s.emailId=:emailId and s.guardian.email=:email ")
	public Student getStudentByemailIdAndGuradianMailId(@Param("emailId")String emailId,@Param("email")String email);
	
	@Modifying
	@Transactional
	@Query(
			value = "update tbl_student set email_address=?1 where gurdian_email=?2",
			nativeQuery = true
			)
	public int updateStudentByGurdianMailId(String email,String gurdianEmail);
}
