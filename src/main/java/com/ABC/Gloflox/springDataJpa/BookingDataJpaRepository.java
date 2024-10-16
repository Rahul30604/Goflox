package com.ABC.Gloflox.springDataJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ABC.Gloflox.Entity.Booking;

@Repository
public interface BookingDataJpaRepository extends JpaRepository <Booking ,Long>{

}
