package org.myself.education.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.myself.education.model.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Director implements Serializable {
	
	private static final long serialVersionUID = 7934706749799975191L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "date_of_birth", columnDefinition = "TIMESTAMP")
	private LocalDateTime dateOfBirth;
	
}
