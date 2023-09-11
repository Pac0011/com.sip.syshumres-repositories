package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.MaritalStatus;


@Repository
public interface MaritalStatusRepository extends PagingAndSortingRepository<MaritalStatus, Long> {
	
	List<MaritalStatus> findByEnabledTrueOrderByDescription();

}
