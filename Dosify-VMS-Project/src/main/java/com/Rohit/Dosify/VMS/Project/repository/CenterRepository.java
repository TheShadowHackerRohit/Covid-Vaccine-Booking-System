package com.Rohit.Dosify.VMS.Project.repository;

import com.Rohit.Dosify.VMS.Project.model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends JpaRepository<VaccinationCenter,Integer> {
}
