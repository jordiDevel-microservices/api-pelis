package org.myself.education.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.myself.education.dto.GenreDTO;
import org.myself.education.exception.NotFoundException;
import org.myself.education.service.GenreService;
import org.springframework.http.HttpStatus;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

public class GenreControllerTest {

	private static final String BASE_URL = "/api/genre";
	
	@Mock
    private GenreService genreService;
	
	@InjectMocks
    private GenreController genreController;
	
	@Rule
    public MockitoRule rule = MockitoJUnit.rule();
	
	@Before
    public void initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.standaloneSetup(this.genreController);
    }
	
	@Test
	public void testListOk() throws Exception {
		when(this.genreService.listAll()).thenReturn(Arrays.asList(GenreDTO.builder().id(1).name("name").build()));
		
		GenreDTO[] response = 
	        given().
	        when().
	        	get(GenreControllerTest.BASE_URL + "/list").
	        then().
	        	log().ifValidationFails().
	        	statusCode(HttpStatus.OK.value()).
	        	contentType(ContentType.JSON).
	        extract().
	        	response().as(GenreDTO[].class);
		
		assertNotNull("Controller returns null", response);
		assertEquals(1, response.length, "Result not contains one element");
		
		verify(this.genreService, times(1)).listAll();
	}
	
	@Test
	public void testListNotFound() throws Exception {
		when(this.genreService.listAll()).thenThrow(NotFoundException.class);
				
		given().
		when().
			get(GenreControllerTest.BASE_URL + "/list").
		then().
			log().ifValidationFails().
			statusCode(HttpStatus.NOT_FOUND.value());
		
		verify(this.genreService, times(1)).listAll();
	}
	
}
