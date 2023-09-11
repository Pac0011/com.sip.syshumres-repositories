package com.sip.syshumres_repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.PasswordRecovery;


@Repository
public interface PasswordRecoveryRepository extends PagingAndSortingRepository<PasswordRecovery, Long> {
	
	public Optional<PasswordRecovery> findOneByUuidAndEnabledTrue(String uuid);

}
