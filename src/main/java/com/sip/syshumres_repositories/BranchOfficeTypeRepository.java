package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.BranchOfficeType;


@Repository
public interface BranchOfficeTypeRepository extends PagingAndSortingRepository<BranchOfficeType, Long> {
	
	@Query("SELECT a FROM BranchOfficeType a WHERE a.description like %?1%")
	public List<BranchOfficeType> findByDescription(String term);
	
	List<BranchOfficeType> findByEnabledTrueOrderByDescription();
	
}
