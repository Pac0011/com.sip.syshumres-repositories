package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.BloodType;

@Repository
public interface BloodTypeRepository extends PagingAndSortingRepository<BloodType, Long> {
	
	List<BloodType> findByEnabledTrueOrderByDescription();

}
