package com.sip.syshumres_repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.EmployeeSpecialCourses;


@Repository
public interface EmployeeSpecialCoursesRepository extends PagingAndSortingRepository<EmployeeSpecialCourses, Long> {

}
