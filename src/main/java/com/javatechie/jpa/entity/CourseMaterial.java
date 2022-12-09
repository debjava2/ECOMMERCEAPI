package com.javatechie.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class CourseMaterial {

	@Id
	@SequenceGenerator(
			name = "material_sequence",
			initialValue = 1,
			sequenceName = "material_sequence"
			
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "material_sequence"
			
			)
	private long materialId;
	private String url;
	
	@OneToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			optional = false
			)
	@JoinColumn(
			name = "course_id",
			referencedColumnName = "courseId"
			)
	private Course course;
	
}
