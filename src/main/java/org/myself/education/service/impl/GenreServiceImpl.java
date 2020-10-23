package org.myself.education.service.impl;

import java.util.List;

import org.myself.education.dto.GenreDTO;
import org.myself.education.entity.Genre;
import org.myself.education.exception.NotFoundException;
import org.myself.education.mapper.GenreMapper;
import org.myself.education.repository.GenreRepository;
import org.myself.education.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private GenreMapper genreMapper;
	
	@Override
	public List<GenreDTO> listAll() {
		List<Genre> entityList = this.genreRepository.findAll();
		
		if (entityList.isEmpty()) {
			throw new NotFoundException("Genres not found");
		}
		
		return this.genreMapper.toDtoList(entityList);
	}

	@Override
	public GenreDTO getById(Long id) {
		return null;
	}

	@Override
	public GenreDTO saveOrUpdate(GenreDTO genreDTO) {
		return null;
	}

	@Override
	public void delete(Long id) {

	}

}
