package com.sip.syshumres_repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.ManagingCompany;


@Repository
public interface ManagingCompanyRepository extends PagingAndSortingRepository<ManagingCompany, Long> {
	
	@Query("SELECT a FROM ManagingCompany a WHERE UPPER(a.description) LIKE CONCAT('%',UPPER(?1),'%') "
			+ "OR UPPER(a.companyName) LIKE CONCAT('%',UPPER(?1),'%') "
            + "OR UPPER(a.rfc) LIKE CONCAT('%',UPPER(?1),'%') "
            + "OR UPPER(a.employerRegistration) LIKE CONCAT('%',UPPER(?1),'%') "
            + "OR UPPER(a.typeHiring.description) LIKE CONCAT('%',UPPER(?1),'%') "
			+ "OR UPPER(a.phoneNumber) LIKE CONCAT('%',UPPER(?1),'%')")
    Page<ManagingCompany> findByDescriptionLikeOrCompanyNameLikeOrRfcLikeOr(String text, Pageable pageable);

}
