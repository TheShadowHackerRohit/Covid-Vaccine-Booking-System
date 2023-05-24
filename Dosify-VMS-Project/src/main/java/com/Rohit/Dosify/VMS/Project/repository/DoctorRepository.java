package com.Rohit.Dosify.VMS.Project.repository;

import com.Rohit.Dosify.VMS.Project.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    @Query(value = "select * from doctor where appointments.count() >= 10",nativeQuery = true)
   public List<Doctor> getDoctorsHaving10Appointment();



}
