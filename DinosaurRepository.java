package com.coderscampus.cp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.cp.domain.Dinosaur;

public interface DinosaurRepository extends JpaRepository<Dinosaur, Long>{

}
