package com.vaudience.coding.exercise.vaudience.repositories;

import com.vaudience.coding.exercise.vaudience.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
