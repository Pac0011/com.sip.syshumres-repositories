package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.DriverLicenseValidity;


@Repository
public interface DriverLicenseValidityRepository extends PagingAndSortingRepository<DriverLicenseValidity, Long> {

	List<DriverLicenseValidity> findByEnabledTrueOrderByDescription();

}
