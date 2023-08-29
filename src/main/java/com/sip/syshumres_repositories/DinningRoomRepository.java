package com.sip.syshumres_repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sip.syshumres_entities.DinningRoom;


@Repository
public interface DinningRoomRepository extends PagingAndSortingRepository<DinningRoom, Long> {

	@Query("SELECT new DinningRoom(a.id, CONCAT(a.description, ' - $ ', a.price)) "
			+ "FROM DinningRoom a WHERE a.enabled = 1 ORDER BY a.description ASC")
	List<DinningRoom> findByEnabledTrueOrderByDescription();
}
