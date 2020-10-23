package org.myself.education.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.myself.education.dto.GenreDTO;
import org.myself.education.entity.Genre;

public class GenreMapperTest {

	@InjectMocks
	private GenreMapperImpl genreMapper;
	
	@Rule
    public MockitoRule rule = MockitoJUnit.rule();
	
	@Test
	public void dto2entity() throws Exception {
		GenreDTO dto = GenreDTO.builder().id(1).name("name").build();
		
		Genre entity = this.genreMapper.toEntity(dto);
		
		assertNotNull("Mapper returns null", entity);
		
		assertEquals(dto.getId(), entity.getId(), "The id property is different");
		assertEquals(dto.getName(), entity.getName(), "The name property is different");
	}
	
	@Test
	public void entity2dto() throws Exception {
		Genre entity = Genre.builder().id(1).name("name").build();
		
		 GenreDTO dto = this.genreMapper.toDto(entity);
		
		assertNotNull("Mapper returns null", dto);
		
		assertEquals(entity.getId(), dto.getId(), "The id property is different");
		assertEquals(entity.getName(), dto.getName(), "The name property is different");
	}
	
}
