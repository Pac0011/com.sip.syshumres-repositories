package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.DriverLicenseType;


@Repository
public interface DriverLicenseTypeRepository extends PagingAndSortingRepository<DriverLicenseType, Long> {

	List<DriverLicenseType> findByEnabledTrueOrderByDescription();

}
