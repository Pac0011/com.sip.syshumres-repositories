package com.sip.syshumres_repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.User;


@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	
	public Optional<User> findOneByUsername(String username);
	
	public Optional<User> findOneByEmail(String email);
	
	public long countByEmail(String email);
	
	public long countByUsername(String username);
	
	@Query("SELECT count(*) FROM User a WHERE a.email = ?1 AND a.id <> ?2")
	public long countByEmailWithAnotherUser(String email, Long id);
	
	@Query("SELECT count(*) FROM User a WHERE a.username = ?1 AND a.id <> ?2")
	public long countByUsernameWithAnotherUser(String username, Long id);
	
	@Query("SELECT a FROM User a WHERE UPPER(a.username) LIKE CONCAT('%',UPPER(?1),'%') "
			+ "OR UPPER(a.firstName) LIKE CONCAT('%',UPPER(?1),'%') "
			+ "OR UPPER(a.branchOffice.description) LIKE CONCAT('%',UPPER(?1),'%') "
			+ "OR UPPER(a.email) LIKE CONCAT('%',UPPER(?1),'%')")
    Page<User> findByUsernameLikeOrFirstNameLikeOrEmailLike(String text, Pageable pageable);

}
