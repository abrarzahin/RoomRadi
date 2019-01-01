package com.fullstack.abrarzahin.angularspring.repository;

import org.springframework.data.repository.CrudRepository;

import com.fullstack.abrarzahin.angularspring.entity.ReservationEntity;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {

}
