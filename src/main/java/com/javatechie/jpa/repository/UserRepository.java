package com.javatechie.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javatechie.jpa.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select u from User u where u.userName = ?1 and u.isActive=true")
	User findByUserName(String username);
	@Query("select u from User u where u.userName = ?1 and u.password=?2")
	User findByUserNameAndPassword(String userName, String password);

}
