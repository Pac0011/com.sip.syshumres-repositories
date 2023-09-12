package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.SchoolGrade;


@Repository
public interface SchoolGradeRepository extends PagingAndSortingRepository<SchoolGrade, Long> {
	
	List<SchoolGrade> findByEnabledTrueOrderByDescription();

}
