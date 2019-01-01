package com.fullstack.abrarzahin.angularspring.repository;




import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fullstack.abrarzahin.angularspring.entity.RoomEntity;
@Repository
public interface RoomRepository extends CrudRepository<RoomEntity,Long> {
	List<RoomEntity> findAllById(Long id);
}
