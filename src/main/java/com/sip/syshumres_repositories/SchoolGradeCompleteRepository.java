package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.SchoolGradeComplete;


@Repository
public interface SchoolGradeCompleteRepository extends PagingAndSortingRepository<SchoolGradeComplete, Long> {
	
	List<SchoolGradeComplete> findByEnabledTrueOrderByDescription();

}
