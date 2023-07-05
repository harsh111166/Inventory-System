package com.inventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.entity.University;

public interface UniversityRepo extends JpaRepository<University, Integer> {

	Optional<University> findByName(String name);

	Optional<University> findByUrl(String url);
}
