package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.ExpertType;


@Repository
public interface ExpertTypeRepository extends PagingAndSortingRepository<ExpertType, Long> {
	
	List<ExpertType> findByEnabledTrueOrderByDescription();

}
