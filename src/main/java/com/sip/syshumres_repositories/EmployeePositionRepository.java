package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.EmployeePosition;


@Repository
public interface EmployeePositionRepository extends PagingAndSortingRepository<EmployeePosition, Long> {

	@Query("SELECT new EmployeePosition(a.id, a.description, a.enabled) "
			+ "FROM EmployeePosition a WHERE a.enabled = 1 ORDER BY a.description ASC")
	List<EmployeePosition> findByEnabledTrueOrderByDescription();
	
	@Query("SELECT new EmployeePosition(a.id, a.description, a.enabled) "
			+ "FROM EmployeePosition a WHERE a.employeeType.id = (?1) AND a.enabled = 1 ORDER BY a.description ASC")
	List<EmployeePosition> findByEnabledTrueOrderByDescription(long idEmployeeType);
	
	@Query("SELECT a FROM EmployeePosition a WHERE UPPER(a.description) LIKE CONCAT('%',UPPER(?1),'%') "
			+ "OR UPPER(a.employeeType.description) LIKE CONCAT('%',UPPER(?1),'%') ")
    Page<EmployeePosition> findByDescriptionLikeOrEmployeeTypeLike(String text, Pageable pageable);
	
}
