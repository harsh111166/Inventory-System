package com.inventory.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dto.UniversityDto;
import com.inventory.entity.University;
import com.inventory.repository.UniversityRepo;
import com.inventory.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {

	@Autowired
	private UniversityRepo universityRepo;

	@Override
	public UniversityDto getByName(String name) {
		UniversityDto universityDto = new UniversityDto();
		Optional<University> universityOptional = universityRepo.findByName(name);
		if (universityOptional.isPresent()) {
			University university = universityOptional.get();
			convertEntityToUniversityDto(universityDto, university);
		}
		return universityDto;
	}

	private void convertEntityToUniversityDto(UniversityDto universityDto, University university) {
		universityDto.setId(university.getId());
		universityDto.setName(university.getName());
		universityDto.setUrl(university.getUrl());
	}
}
