package com.Rohit.Dosify.VMS.Project.repository;

import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.UserResponseDTO;
import com.Rohit.Dosify.VMS.Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public User getByEmailId(String emailId);

    @Query(value = "select * from user where is_dose1_taken = false",nativeQuery = true)
    public List<User> getAllUnvaccinatedUser();

    @Query(value = "select * from user where is_dose2_taken = true",nativeQuery = true)
    public List<User> getAllFullyVaccinatedUser();

    @Query(value = "select * from user where is_dose1_taken = false AND gender = 'MALE'",nativeQuery = true)
    public List<User> getNonVaccinatedMaleUser();

    @Query(value = "select * from user where is_dose2_taken = true AND gender = 'FEMALE'",nativeQuery = true)
    public List<User> getFullVaccinatedFemaleUser();

    @Query(value = "select * from user where is_dose1_taken = true",nativeQuery = true)
    public List<User> getOnlyDose1User();
}
