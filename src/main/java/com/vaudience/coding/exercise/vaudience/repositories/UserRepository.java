package com.vaudience.coding.exercise.vaudience.repositories;

import com.vaudience.coding.exercise.vaudience.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "Select * from user where username = ?1",nativeQuery = true)
    User findUserByUsername(String username);

}
