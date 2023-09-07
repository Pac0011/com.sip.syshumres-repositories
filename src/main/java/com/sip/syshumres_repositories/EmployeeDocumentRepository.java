package com.sip.syshumres_repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.EmployeeDocument;


@Repository
public interface EmployeeDocumentRepository extends PagingAndSortingRepository<EmployeeDocument, Long> {
	
	@Query("SELECT a FROM EmployeeDocument a WHERE a.employeeProfile.id = ?1 AND a.hiringDocuments.id = ?2")
	Optional<EmployeeDocument> findByEmployeeProfileAndHiringDocument(Long idEmployeeProfile, Long idHiringDocuments);

}
