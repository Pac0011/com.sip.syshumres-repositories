package com.sip.syshumres_repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.ProspectProfile;


@Repository
public interface ProspectProfileRepository extends PagingAndSortingRepository<ProspectProfile, Long> {
	
	@Query("SELECT a FROM ProspectProfile a WHERE a.branchOffice.id = ?1")
	public Page<ProspectProfile> listBranchOffice(Long idBranchOffice, Pageable pageable);
	
	@Query("SELECT a FROM ProspectProfile a "
			+ " WHERE a.branchOffice.id = ?1 "
			+ "AND (UPPER(a.firstName) LIKE CONCAT('%',UPPER(?2),'%') "
			+ "OR UPPER(a.lastName) LIKE CONCAT('%',UPPER(?2),'%') "
            + "OR UPPER(a.lastNameSecond) LIKE CONCAT('%',UPPER(?2),'%') "
            + "OR UPPER(a.curp) LIKE CONCAT('%',UPPER(?2),'%') "
	        + "OR UPPER(a.rfc) LIKE CONCAT('%',UPPER(?2),'%')) ")
    Page<ProspectProfile> findByFullNameLikeOrRfcLikeOrCurpLikeOr(Long idBranchOffice, String text, Pageable pageable);
	
	@Query("SELECT a FROM ProspectProfile a "
			+ " WHERE UPPER(a.firstName) LIKE CONCAT('%',UPPER(?1),'%') "
			+ "OR UPPER(a.lastName) LIKE CONCAT('%',UPPER(?1),'%') "
            + "OR UPPER(a.lastNameSecond) LIKE CONCAT('%',UPPER(?1),'%') "
            + "OR UPPER(a.curp) LIKE CONCAT('%',UPPER(?1),'%') "
	        + "OR UPPER(a.rfc) LIKE CONCAT('%',UPPER(?1),'%') ")
    Page<ProspectProfile> findByFullNameLikeOrRfcLikeOrCurpLikeOr(String text, Pageable pageable);
	
	@Query("SELECT count(*) FROM ProspectProfile a WHERE a.email = ?1 AND a.id <> ?2")
	public long countByEmailWithAnotherProspect(String email, Long id);
	
	@Query("SELECT count(*) FROM ProspectProfile a WHERE a.curp = ?1 AND a.id <> ?2")
	public long countByCurpWithAnotherProspect(String curp, Long id);
	
	@Query("SELECT count(*) FROM ProspectProfile a WHERE a.rfc = ?1 AND a.id <> ?2")
	public long countByRfcWithAnotherProspect(String rfc, Long id);

}
