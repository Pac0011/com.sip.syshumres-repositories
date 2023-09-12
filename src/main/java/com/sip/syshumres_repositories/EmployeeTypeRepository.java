package com.sip.syshumres_repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.EmployeeType;


@Repository
public interface EmployeeTypeRepository extends PagingAndSortingRepository<EmployeeType, Long> {

}
