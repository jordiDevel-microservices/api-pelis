package org.myself.education.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.myself.education.dto.GenreDTO;
import org.myself.education.entity.Genre;
import org.myself.education.exception.NotFoundException;
import org.myself.education.mapper.GenreMapper;
import org.myself.education.repository.GenreRepository;
import org.myself.education.service.impl.GenreServiceImpl;

public class GenreServiceTest {

	@Mock
	private GenreRepository genreRepository;
	
	@Mock
	private GenreMapper genreMapper;

	@InjectMocks
	private GenreServiceImpl genreService;

	@Rule
    public MockitoRule rule = MockitoJUnit.rule();
	
	@Test
	public void testListOk() throws Exception {
		when(this.genreRepository.findAll()).thenReturn(Arrays.asList(Genre.builder().id(1).name("name").build()));
		when(this.genreMapper.toDtoList(ArgumentMatchers.anyList())).thenReturn(Arrays.asList(GenreDTO.builder().id(1).name("name").build()));
		
		List<GenreDTO> genres = this.genreService.listAll();
		
		assertNotNull("Genres list is null", genres);
		assertFalse("Genres list is empty", genres.isEmpty());
		
		verify(this.genreRepository, times(1)).findAll();
		verify(this.genreMapper, times(1)).toDtoList(ArgumentMatchers.anyList());
	}
	
	@Test(expected = NotFoundException.class)
	public void testNotFound() throws Exception {
		when(this.genreRepository.findAll()).thenReturn(new ArrayList<>());
		
		this.genreService.listAll();
		
		verify(this.genreRepository, times(1)).findAll();
		verify(this.genreMapper, never()).toDtoList(ArgumentMatchers.anyList());
	}
	
}
