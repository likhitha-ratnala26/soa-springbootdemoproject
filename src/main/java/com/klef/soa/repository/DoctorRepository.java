package com.klef.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Doctor;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	//from Doctor d where d.gender=?1
	//this is a signature method, must be written here only
	List<Doctor> findByGender(String gender);
}
