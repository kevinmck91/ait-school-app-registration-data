package com.school.registrationdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.school.registrationdata.dtos.RegistrationData;

import java.util.List;
import java.util.Optional;

public interface RegistrationDataRepository extends JpaRepository<RegistrationData, Long> {

	List<RegistrationData> findById(Optional<Integer> id);

	Optional<RegistrationData> findByStudentNumber(String studentNumber);

}
