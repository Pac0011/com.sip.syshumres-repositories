package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.Module;


@Repository
public interface ModuleRepository extends PagingAndSortingRepository<Module, Long> {
	
	@Query("SELECT new Module(a.id, a.description) "
			+ "FROM Module a WHERE a.enabled = 1 ORDER BY a.description ASC")
	public List<Module> findByEnabledTrueOrderByDescription();
	
	@Query(value = "SELECT DISTINCT m.* "
            + "FROM users_authorities ua "
            + "INNER JOIN users u ON u.id = ua.user_id "
            + "INNER JOIN authorities a ON a.id = ua.authority_id "
            + "INNER JOIN authorities_modules am ON am.authority_id = a.id "
            + "INNER JOIN modules m ON m.id = am.module_id "
            + "WHERE u.username = ?1 AND m.enabled = 1 AND father_id is null "
            + "ORDER BY m.description ASC", nativeQuery = true)
    public List<Module> findModulesFatherByUsername(String username);
	
	@Query(value = "SELECT DISTINCT m.* "
            + "FROM users_authorities ua "
            + "INNER JOIN users u ON u.id = ua.user_id "
            + "INNER JOIN authorities a ON a.id = ua.authority_id "
            + "INNER JOIN authorities_modules am ON am.authority_id = a.id "
            + "INNER JOIN modules m ON m.id = am.module_id "
            + "WHERE u.username = ?1 AND m.enabled = 1 AND father_id is not null "
            + "ORDER BY m.description ASC", nativeQuery = true)
    public List<Module> findModulesChildByUsername(String username);
	
	@Query("SELECT a FROM Module a WHERE UPPER(a.description) "
			+ "LIKE CONCAT('%',UPPER(?1),'%') "
			+ "OR UPPER(a.url) LIKE CONCAT('%',UPPER(?1),'%') "
			+ "OR UPPER(a.detail) LIKE CONCAT('%',UPPER(?1),'%')")
    Page<Module> findByDescriptionLikeOrUrlLikeOrDetail(String text, Pageable pageable);	

}
