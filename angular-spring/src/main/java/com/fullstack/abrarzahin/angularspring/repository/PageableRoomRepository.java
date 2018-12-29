package com.fullstack.abrarzahin.angularspring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fullstack.abrarzahin.angularspring.entity.RoomEntity;

public interface PageableRoomRepository extends  PagingAndSortingRepository<RoomEntity, Long> {
	
	Page<RoomEntity> findById(Long id, Pageable page);
	
	
	
}
