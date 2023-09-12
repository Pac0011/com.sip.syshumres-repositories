package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.EmployeeTypeHealth;


@Repository
public interface EmployeeTypeHealthRepository extends PagingAndSortingRepository<EmployeeTypeHealth, Long> {

	List<EmployeeTypeHealth> findByEnabledTrueOrderByDescription();
}
