package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.Gender;


@Repository
public interface GenderRepository extends PagingAndSortingRepository<Gender, Long> {
	
	List<Gender> findByEnabledTrueOrderByDescription();

}
