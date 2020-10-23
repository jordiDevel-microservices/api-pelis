package org.myself.education.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.myself.education.dto.GenreDTO;
import org.myself.education.entity.Genre;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface GenreMapper {

	Genre toEntity(GenreDTO dto);
	GenreDTO toDto(Genre entity);
	
	List<Genre> toEntityList(List<GenreDTO> dtoList);
	List<GenreDTO> toDtoList(List<Genre> entityList);
	
}
