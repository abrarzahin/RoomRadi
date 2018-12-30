package com.fullstack.abrarzahin.angularspring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fullstack.abrarzahin.angularspring.entity.RoomEntity;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
	 List<RoomEntity> findByNumber(Long id);

}
