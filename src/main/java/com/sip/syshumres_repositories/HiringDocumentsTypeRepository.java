package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.HiringDocumentsType;


@Repository
public interface HiringDocumentsTypeRepository extends PagingAndSortingRepository<HiringDocumentsType, Long> {
			
	List<HiringDocumentsType> findByEnabledTrueOrderByDescription();

}
