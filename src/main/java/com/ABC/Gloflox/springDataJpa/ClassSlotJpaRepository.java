package com.ABC.Gloflox.springDataJpa;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ABC.Gloflox.Entity.ClassSlots;

@Repository
public interface ClassSlotJpaRepository extends JpaRepository<ClassSlots,Long> {

	 Optional<ClassSlots> findByClassesIdAndSlotDate(Long classId, LocalDate slotDate);
}
