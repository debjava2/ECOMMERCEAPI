package com.javatechie.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Teacher {

	@Id
	@SequenceGenerator(
			name = "teacher_sequence",
			allocationSize = 1,
			sequenceName = "teacher_sequence"		
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "teacher_sequence"
			)
	private Long teacherId;
	private String firstName;
	private String lastName;
	
	//Commenting the Code for Many to One Realtionship in Order to use oneToMany uncomment this 
	//and the correspoind code in Course class
	
	
	/*
	 * @OneToMany( cascade =CascadeType.ALL, fetch = FetchType.LAZY )
	 * 
	 * @JoinColumn( name = "teacherId", referencedColumnName = "teacherId" ) private
	 * List<Course> course;
	 */
	
}
