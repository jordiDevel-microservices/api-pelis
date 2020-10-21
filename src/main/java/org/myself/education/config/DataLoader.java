package org.myself.education.config;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.myself.education.entity.Cast;
import org.myself.education.entity.Country;
import org.myself.education.entity.Director;
import org.myself.education.entity.Film;
import org.myself.education.entity.Genre;
import org.myself.education.model.Gender;
import org.myself.education.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private FilmRepository filmRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Genre> genres = Arrays.asList(
			Genre.builder().name("Comedy").build(),
			Genre.builder().name("Action").build(),
			Genre.builder().name("Thriller").build(),
			Genre.builder().name("Drama").build(),
			Genre.builder().name("Based on a true story").build(),
			Genre.builder().name("Romance").build(),
			Genre.builder().name("Horror").build(),
			Genre.builder().name("Fantasy").build(),
			Genre.builder().name("Animation").build(),
			Genre.builder().name("Mystery").build(),
			Genre.builder().name("Sci-Fi").build(),
			Genre.builder().name("Documentary").build(),
			Genre.builder().name("Biography").build()
		);
		
		List<Country> countries = Arrays.asList(
			Country.builder().code("ES").name("Spain").build(),
			Country.builder().code("FR").name("France").build(),
			Country.builder().code("US").name("United States").build(),
			Country.builder().code("IT").name("Italy").build(),
			Country.builder().code("MX").name("Mexico").build(),
			Country.builder().code("UK").name("United Kingdom").build()
		);
		
		List<Director> directors = Arrays.asList(
			Director.builder().name("Bob Esponja").gender(Gender.MALE).dateOfBirth(LocalDateTime.of(1946, 1, 20, 0, 0)).build(),
			Director.builder().name("Chun Li").gender(Gender.FEMALE).dateOfBirth(LocalDateTime.of(1968, 9, 8, 0, 0)).build(),
			Director.builder().name("Enjuto Mojamuto").gender(Gender.MALE).dateOfBirth(LocalDateTime.of(1977, 3, 14, 0, 0)).build(),
			Director.builder().name("Lola Flores").gender(Gender.FEMALE).dateOfBirth(LocalDateTime.of(1952, 5, 22, 0, 0)).build(),
			Director.builder().name("Son Goku").gender(Gender.MALE).dateOfBirth(LocalDateTime.of(1992, 8, 3, 0, 0)).build(),
			Director.builder().name("Ana Torroja").gender(Gender.FEMALE).dateOfBirth(LocalDateTime.of(1966, 11, 29, 0, 0)).build()
		);
		
		List<Cast> characters = Arrays.asList(
			Cast.builder().name("Brad Pitt").gender(Gender.MALE).dateOfBirth(LocalDateTime.of(1963, 12, 18, 0, 0)).build(),
			Cast.builder().name("Ana de Armas").gender(Gender.FEMALE).dateOfBirth(LocalDateTime.of(1988, 4, 30, 0, 0)).build(),
			Cast.builder().name("Leonardo di Caprio").gender(Gender.MALE).dateOfBirth(LocalDateTime.of(1974, 11, 11, 0, 0)).build(),
			Cast.builder().name("Kate Beckinsale").gender(Gender.FEMALE).dateOfBirth(LocalDateTime.of(1973, 7, 26, 0, 0)).build(),
			Cast.builder().name("Keanu Reeves").gender(Gender.MALE).dateOfBirth(LocalDateTime.of(1975, 3, 1, 0, 0)).build(),
			Cast.builder().name("Rachel McAdams").gender(Gender.FEMALE).dateOfBirth(LocalDateTime.of(1979, 11, 30, 0, 0)).build(),
			Cast.builder().name("Morgan Freeman").gender(Gender.MALE).dateOfBirth(LocalDateTime.of(1981, 2, 11, 0, 0)).build(),
			Cast.builder().name("Emma Stone").gender(Gender.FEMALE).dateOfBirth(LocalDateTime.of(1994, 1, 14, 0, 0)).build(),
			Cast.builder().name("Tom Cruise").gender(Gender.MALE).dateOfBirth(LocalDateTime.of(1962, 2, 19, 0, 0)).build(),
			Cast.builder().name("Demi Moore").gender(Gender.FEMALE).dateOfBirth(LocalDateTime.of(1960, 6, 24, 0, 0)).build(),
			Cast.builder().name("Robert de Niro").gender(Gender.MALE).dateOfBirth(LocalDateTime.of(1970, 8, 31, 0, 0)).build(),
			Cast.builder().name("Elisabeth Shue").gender(Gender.FEMALE).dateOfBirth(LocalDateTime.of(1972, 9, 12, 0, 0)).build()
		);
		
		List<String> titles = Arrays.asList("John Wick", "Avatar", "Fight's Club", "Cocktail", "The Joker", "Matrix");
		
		List<Integer> durations = Arrays.asList(98, 112, 134, 99, 109, 100);
		
		List<Integer> years = Arrays.asList(2001, 2014, 2005, 2009, 2011, 2017);
		
		for (int i = 0; i < titles.size(); i++) {
			this.filmRepository.save(
				Film.builder()
					.title(titles.get(i))
					.duration(durations.get(i))
					.year(years.get(i))
					.genres(genres.subList(i * 2, (i * 2) + 2))
					.country(countries.get(i))
					.directors(Arrays.asList(directors.get(i)))
					.characters(characters.subList(i * 2, (i * 2) + 2))
				.build()
			);
		}
	}

}
