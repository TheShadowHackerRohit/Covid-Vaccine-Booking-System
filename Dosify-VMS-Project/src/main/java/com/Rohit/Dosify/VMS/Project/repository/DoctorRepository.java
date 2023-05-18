package com.Rohit.Dosify.VMS.Project.repository;

import com.Rohit.Dosify.VMS.Project.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

}
