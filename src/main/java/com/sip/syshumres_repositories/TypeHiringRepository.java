package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.TypeHiring;


@Repository
public interface TypeHiringRepository extends PagingAndSortingRepository<TypeHiring, Long> {
	
	List<TypeHiring> findByEnabledTrueOrderByDescription();

}
