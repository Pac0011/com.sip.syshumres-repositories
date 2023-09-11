package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.AddressState;


@Repository
public interface AddressStateRepository extends PagingAndSortingRepository<AddressState, Long> {
	
	List<AddressState> findByEnabledTrueOrderByDescription();

}
