package com.sip.syshumres_repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.EmployeeProfile;


@Repository
public interface EmployeeProfileRepository extends PagingAndSortingRepository<EmployeeProfile, Long> {
	
	@Query("SELECT a FROM EmployeeProfile a WHERE a.branchOffice.id = ?1 AND a.employeePosition.employeeType.id = ?2")
	public Page<EmployeeProfile> listEmployeeType(Long idBranchOffice, Long idEmployeeType, Pageable pageable);
	
	@Query("SELECT a FROM EmployeeProfile a WHERE a.employeePosition.employeeType.id = ?1")
	public Page<EmployeeProfile> listEmployeeType(Long idEmployeeType, Pageable pageable);
	
	@Query("SELECT count(*) FROM EmployeeProfile a WHERE a.email = ?1 AND a.id <> ?2")
	public long countByEmailWithAnotherEmployee(String email, Long id);
	
	@Query("SELECT count(*) FROM EmployeeProfile a WHERE a.curp = ?1 AND a.id <> ?2")
	public long countByCurpWithAnotherEmployee(String curp, Long id);
	
	@Query("SELECT count(*) FROM EmployeeProfile a "
			+ "JOIN a.employeePayroll b WHERE b.nss = ?1 AND a.id <> ?2")
	public long countByNssWithAnotherEmployee(String nss, Long id);
	
	@Query("SELECT count(*) FROM EmployeeProfile a "
			+ "JOIN a.employeePayroll b WHERE b.rfc = ?1 AND a.id <> ?2")
	public long countByRfcWithAnotherEmployee(String rfc, Long id);
	
	@Query("SELECT count(*) FROM EmployeeProfile a "
			+ "JOIN a.employeePayroll b WHERE b.bankAccount = ?1 AND a.id <> ?2")
	public long countByBankAccountWithAnotherEmployee(String bankAccount, Long id);
	
	@Query("SELECT count(*) FROM EmployeeProfile a "
			+ "JOIN a.employeePayroll b WHERE b.clabe = ?1 AND a.id <> ?2")
	public long countByClabeWithAnotherEmployee(String clabe, Long id);
	
	@Query("SELECT count(*) FROM EmployeeProfile a WHERE a.lastName = ?1 AND a.lastNameSecond = ?2")
	public long countByNameAnotherEmployee(String lastName, String lastNameSecond);
	
	@Query("SELECT a FROM EmployeeProfile a WHERE a.employeeClinicalData.id = ?1")
	public Optional<EmployeeProfile> findByIdEmployeeClinicalData(Long id);
	
	@Query("SELECT a FROM EmployeeProfile a WHERE a.employeePayroll.id = ?1")
	public Optional<EmployeeProfile> findByIdEmployeePayroll(Long id);
	
	@Query("SELECT a FROM EmployeeProfile a LEFT JOIN a.employeeArea e "
			+ " WHERE a.branchOffice.id = ?1 AND a.employeePosition.employeeType.id = ?2 "
			+ "AND (UPPER(a.firstName) LIKE CONCAT('%',UPPER(?3),'%') "
			+ "OR UPPER(a.lastName) LIKE CONCAT('%',UPPER(?3),'%') "
            + "OR UPPER(a.lastNameSecond) LIKE CONCAT('%',UPPER(?3),'%') "
            + "OR UPPER(a.employeeNumber) LIKE CONCAT('%',UPPER(?3),'%') "
            + "OR UPPER(a.curp) LIKE CONCAT('%',UPPER(?3),'%') "
            + "OR UPPER(a.employeePositionProfile.description) LIKE CONCAT('%',UPPER(?3),'%') "
	        + "OR UPPER(a.employeePayroll.rfc) LIKE CONCAT('%',UPPER(?3),'%') "
	        + "OR UPPER(a.employeePayroll.nss) LIKE CONCAT('%',UPPER(?3),'%') "
	        + "OR UPPER(e.description) LIKE CONCAT('%',UPPER(?3),'%')) ")
    Page<EmployeeProfile> findByFullNameLikeOrRfcLikeOrCurpLikeOr(Long idBranchOffice, Long idEmployeeType, String text, Pageable pageable);
	
	@Query("SELECT a FROM EmployeeProfile a LEFT JOIN a.employeeArea e "
			+ " WHERE a.employeePosition.employeeType.id = ?1 "
			+ "AND (UPPER(a.firstName) LIKE CONCAT('%',UPPER(?2),'%') "
			+ "OR UPPER(a.lastName) LIKE CONCAT('%',UPPER(?2),'%') "
            + "OR UPPER(a.lastNameSecond) LIKE CONCAT('%',UPPER(?2),'%') "
            + "OR UPPER(a.employeeNumber) LIKE CONCAT('%',UPPER(?2),'%') "
            + "OR UPPER(a.curp) LIKE CONCAT('%',UPPER(?2),'%') "
            + "OR UPPER(a.employeePositionProfile.description) LIKE CONCAT('%',UPPER(?2),'%') "
	        + "OR UPPER(a.employeePayroll.rfc) LIKE CONCAT('%',UPPER(?2),'%') "
	        + "OR UPPER(a.employeePayroll.nss) LIKE CONCAT('%',UPPER(?2),'%') "
	        + "OR UPPER(e.description) LIKE CONCAT('%',UPPER(?2),'%')) ")
    Page<EmployeeProfile> findByFullNameLikeOrRfcLikeOrCurpLikeOr(Long idEmployeeType, String text, Pageable pageable);

}
