package org.myself.education.controller;

import java.util.List;

import org.myself.education.dto.GenreDTO;
import org.myself.education.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("api/genre")
@Api(value = "GenreController", produces = MediaType.APPLICATION_JSON_VALUE)
public class GenreController {

	@Autowired
	private GenreService genreService;
	
	@ApiOperation(value = "Get all film genres")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = List.class)
	})
	@GetMapping("/list")
	public ResponseEntity<List<GenreDTO>> getAll() {
		return new ResponseEntity<>(this.genreService.listAll(), HttpStatus.OK);
	}
	
}
