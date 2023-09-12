package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.ReasonQuitJob;


@Repository
public interface ReasonQuitJobRepository extends PagingAndSortingRepository<ReasonQuitJob, Long> {
	
	List<ReasonQuitJob> findByEnabledTrueOrderByDescription();

}
