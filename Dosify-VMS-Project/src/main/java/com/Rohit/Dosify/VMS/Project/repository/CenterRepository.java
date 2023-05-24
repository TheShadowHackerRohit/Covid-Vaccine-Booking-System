package com.Rohit.Dosify.VMS.Project.repository;

import com.Rohit.Dosify.VMS.Project.Enum.CenterType;
import com.Rohit.Dosify.VMS.Project.model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CenterRepository extends JpaRepository<VaccinationCenter,Integer> {
    @Query(value = "select * from vaccination_center where center_type =:centerType",nativeQuery = true)
    List<VaccinationCenter> getAllCenterOfACenterType(CenterType centerType);
}
