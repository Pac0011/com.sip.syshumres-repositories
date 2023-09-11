package com.sip.syshumres_repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.OtherReasonQuitJob;


@Repository
public interface OtherReasonQuitJobRepository extends PagingAndSortingRepository<OtherReasonQuitJob, Long> {
	
	@Query("SELECT a FROM OtherReasonQuitJob a WHERE UPPER(a.description) LIKE CONCAT('%',UPPER(?1),'%') ")
    Page<OtherReasonQuitJob> findByDescriptionLike(String text, Pageable pageable);

}
