package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.InvoicedResourceType;


@Repository
public interface InvoicedResourceTypeRepository extends PagingAndSortingRepository<InvoicedResourceType, Long> {

	List<InvoicedResourceType> findByEnabledTrueOrderByDescription();
}
