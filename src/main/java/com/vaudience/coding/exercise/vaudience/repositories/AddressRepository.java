package com.vaudience.coding.exercise.vaudience.repositories;

import com.vaudience.coding.exercise.vaudience.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address,Long> {


}
