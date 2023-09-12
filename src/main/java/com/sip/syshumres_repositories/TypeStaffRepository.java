package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.TypeStaff;


@Repository
public interface TypeStaffRepository extends PagingAndSortingRepository<TypeStaff, Long> {
	
	List<TypeStaff> findByEnabledTrueOrderByDescription();

}
