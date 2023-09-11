package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.PayrollType;


@Repository
public interface PayrollTypeRepository extends PagingAndSortingRepository<PayrollType, Long> {
	
	List<PayrollType> findByEnabledTrueOrderByDescription();
	
	@Query("SELECT new PayrollType(a.id, a.description, a.enabled) "
			+ "FROM PayrollType a WHERE a.id in(1,2) AND a.enabled = 1 ORDER BY a.description ASC")
	List<PayrollType> findNormalByEnabledTrueOrderByDescription();

}
