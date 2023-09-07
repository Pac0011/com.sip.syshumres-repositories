package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.HiringDocuments;


@Repository
public interface HiringDocumentsRepository extends PagingAndSortingRepository<HiringDocuments, Long> {
	
	List<HiringDocuments> findByEnabledTrueOrderByDescription();
	
	@Query("SELECT a FROM HiringDocuments a WHERE UPPER(a.description) LIKE CONCAT('%',UPPER(?1),'%') "
			+ "OR UPPER(a.hiringDocumentsType.description) LIKE CONCAT('%',UPPER(?1),'%') ")
    Page<HiringDocuments> findByDescriptionLikeOrHiringDocumentsTypeLike(String text, Pageable pageable);

}
