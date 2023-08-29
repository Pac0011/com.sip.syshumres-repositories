package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.Authority;


@Repository
public interface AuthorityRepository extends PagingAndSortingRepository<Authority, Long> {
	
	@Query("SELECT new Authority(a.id, a.description) "
			+ "FROM Authority a WHERE a.enabled = 1 ORDER BY a.description ASC")
	List<Authority> findByEnabledTrueOrderByDescription();
	
	@Query(value = "SELECT a.* "
			+ "FROM users_authorities ua "
			+ "INNER JOIN users u ON u.id = ua.user_id "
			+ "INNER JOIN authorities a ON a.id = ua.authority_id "
			+ "WHERE u.username = ?1 AND a.enabled = 1", nativeQuery = true)
	public List<Authority> findAuthoritiesByUsername(String username);
	
	@Query(value = "SELECT count(*) FROM authorities_modules a "
			+ " WHERE a.authority_id = ?1 AND a.module_id = ?2", nativeQuery = true)
	public long countByAuthorityIdAndModuleId(Long authorityId, Long moduleId);
	
	@Query("SELECT a FROM Authority a WHERE UPPER(a.description) LIKE CONCAT('%',UPPER(?1),'%') "
			+ "OR UPPER(a.detail) LIKE CONCAT('%',UPPER(?1),'%') ")
    Page<Authority> findByDescriptionLikeOrDetailLike(String text, Pageable pageable);

}
