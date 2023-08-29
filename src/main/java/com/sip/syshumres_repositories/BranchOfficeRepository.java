package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.BranchOffice;


@Repository
public interface BranchOfficeRepository extends PagingAndSortingRepository<BranchOffice, Long> {
	
	@Query("SELECT new BranchOffice(a.id, a.description) "
			+ "FROM BranchOffice a WHERE a.enabled = 1 ORDER BY a.description ASC")
	List<BranchOffice> findByEnabledTrueOrderByDescription();
	
	@Query("SELECT a FROM BranchOffice a WHERE UPPER(a.description) LIKE CONCAT('%',UPPER(?1),'%') "
			+ "OR UPPER(a.branchOfficeType.description) LIKE CONCAT('%',UPPER(?1),'%') "
            + "OR UPPER(a.costCenter.description) LIKE CONCAT('%',UPPER(?1),'%') "
            + "OR UPPER(a.region.description) LIKE CONCAT('%',UPPER(?1),'%') "
            + "OR UPPER(a.email) LIKE CONCAT('%',UPPER(?1),'%') "
			+ "OR UPPER(a.phoneNumber) LIKE CONCAT('%',UPPER(?1),'%')")
    Page<BranchOffice> findByDescriptionLikeOrBranchOfficeTypeLikeOrCostCenterLikeOr(String text, Pageable pageable);

}
