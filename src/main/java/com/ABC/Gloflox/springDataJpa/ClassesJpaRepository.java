package com.ABC.Gloflox.springDataJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ABC.Gloflox.Entity.Classes;

@Repository
public interface ClassesJpaRepository extends JpaRepository<Classes,Long> {

	List<Classes> findAll();
	

}
