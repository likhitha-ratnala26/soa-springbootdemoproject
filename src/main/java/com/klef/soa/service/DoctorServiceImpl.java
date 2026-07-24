package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Doctor;
import com.klef.soa.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService{
	@Autowired
	     //autowired means connection between managed objects
	private DoctorRepository repo;
	
	@Override
	public Doctor addDoctor(Doctor d) {
		// TODO Auto-generated method stub
		// save is the insert method here
		return repo.save(d);
	}

	@Override
	public Doctor updateDoctor(Doctor d) {
		// TODO Auto-generated method stub
		Optional<Doctor> optional = repo.findById(d.getId());
		if(optional.isPresent())
		{
			Doctor doctor = optional.get();
			doctor.setName(d.getName());
			doctor.setSalary(d.getSalary());
			doctor.setExperience(d.getExperience());
			doctor.setContact(d.getContact());
			
			//here save performs insert and update operation
			return repo.save(doctor);
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Doctor> displayAllDoctors() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Doctor displayDoctorById(Long id) {
		// TODO Auto-generated method stub
		//optional class(is a container which checks if object is present or not, using isEmpty and isPresent) is used here
		return repo.findById(id).orElse(null);
	}

	@Override
	public String deleteDoctorById(Long id) {
		// TODO Auto-generated method stub
		//first checks if id exists or not, stores the id value true/false in variable named flag, and then performs the required action using if-else condition 
		boolean flag = repo.existsById(id);
		if(flag)
		{
			repo.deleteById(id);
			return "Doctor Deleted Successfully";
			
		}
		else
		{
			return "Doctor ID Not Found";
		}
	}

	@Override
	public List<Doctor> displayDoctorsByGender(String gender) {
		//signature method is used
		return repo.findByGender(gender);
	}
	
}
