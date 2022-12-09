package com.javatechie.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javatechie.jpa.entity.Course;
public interface CourseRepository extends JpaRepository<Course, Long> {

}
