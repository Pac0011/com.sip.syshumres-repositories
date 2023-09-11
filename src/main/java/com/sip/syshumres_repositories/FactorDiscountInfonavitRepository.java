package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.FactorDiscountInfonavit;


@Repository
public interface FactorDiscountInfonavitRepository extends PagingAndSortingRepository<FactorDiscountInfonavit, Long> {
	
	List<FactorDiscountInfonavit> findByEnabledTrueOrderByDescription();

}
