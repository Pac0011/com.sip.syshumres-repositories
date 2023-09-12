package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.VaccineDose;


@Repository
public interface VaccineDoseRepository extends PagingAndSortingRepository<VaccineDose, Long> {
	
	List<VaccineDose> findByEnabledTrueOrderByDescription();

}
