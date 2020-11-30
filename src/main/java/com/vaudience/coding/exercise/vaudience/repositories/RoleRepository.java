package com.vaudience.coding.exercise.vaudience.repositories;

import com.vaudience.coding.exercise.vaudience.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
