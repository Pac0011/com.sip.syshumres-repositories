package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.EmployeePositionProfile;


@Repository
public interface EmployeePositionProfileRepository extends PagingAndSortingRepository<EmployeePositionProfile, Long> {

	List<EmployeePositionProfile> findByEnabledTrueOrderByDescription();
	
	@Query("SELECT a FROM EmployeePositionProfile a WHERE UPPER(a.description) LIKE CONCAT('%',UPPER(?1),'%') "
			+ "OR UPPER(a.typeStaff.description) LIKE CONCAT('%',UPPER(?1),'%') ")
    Page<EmployeePositionProfile> findByDescriptionLikeOrTypeStaffLike(String text, Pageable pageable);
}
