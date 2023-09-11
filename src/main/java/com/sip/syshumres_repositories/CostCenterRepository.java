package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.CostCenter;


@Repository
public interface CostCenterRepository extends PagingAndSortingRepository<CostCenter, Long> {
	
	List<CostCenter> findByEnabledTrueOrderByDescription();
	
	@Query("SELECT a FROM CostCenter a WHERE UPPER(a.description) LIKE CONCAT('%',UPPER(?1),'%') "
			+ "OR UPPER(a.code) LIKE CONCAT('%',UPPER(?1),'%') ")
    Page<CostCenter> findByDescriptionLikeOrCodeLike(String text, Pageable pageable);

}
