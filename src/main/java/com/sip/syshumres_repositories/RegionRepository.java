package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.Region;


@Repository
public interface RegionRepository extends PagingAndSortingRepository<Region, Long> {
	
	List<Region> findByEnabledTrueOrderByDescription();

}
