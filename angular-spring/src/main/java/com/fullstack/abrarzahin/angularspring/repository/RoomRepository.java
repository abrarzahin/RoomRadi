package com.fullstack.abrarzahin.angularspring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fullstack.abrarzahin.angularspring.entity.RoomEntity;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
	 RoomEntity  findByNumber(Long id);

}
