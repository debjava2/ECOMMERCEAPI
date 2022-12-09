package com.javatechie.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class Course {

	@Id
	@SequenceGenerator(
			name = "course_sequence",
			allocationSize = 1,
			sequenceName = "course_sequence"
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "course_sequence"
			)
	
	private Long courseId;
	private String title;
	private Integer creadit;
	
	//Bidirectioanl Mapping
	@OneToOne(
			mappedBy = "course"
			)
	private CourseMaterial courseMaterial;
	
	@ManyToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name = "teacher_Id",
			referencedColumnName = "teacherId"
			)
	private Teacher teacher;
}
