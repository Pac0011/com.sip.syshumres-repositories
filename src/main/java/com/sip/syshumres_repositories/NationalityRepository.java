package com.sip.syshumres_repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.Nationality;


@Repository
public interface NationalityRepository extends PagingAndSortingRepository<Nationality, Long> {

}
