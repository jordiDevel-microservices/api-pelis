package org.myself.education.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Film implements Serializable {
	
	private static final long serialVersionUID = -6628899541227090500L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String title;
	
	@Column
	private Integer year;
	
	@Column
	private Integer duration;
	
	@OneToMany(cascade = { CascadeType.ALL })
	private List<Genre> genres;
	
	@OneToMany(cascade = { CascadeType.ALL })
	private List<Director> directors;
	
	@OneToMany(cascade = { CascadeType.ALL })
	private List<Cast> characters;
	
	@OneToOne(cascade = { CascadeType.ALL })
	private Country country;
	
	@Column(name = "url_cover")
	private String urlCover;
	
}
