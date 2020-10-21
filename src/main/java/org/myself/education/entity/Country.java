package org.myself.education.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country implements Serializable {

	private static final long serialVersionUID = -5387939364611493898L;

	@Id
	private String code;
	
	@Column
	private String name;
	
	@Column(name = "url_flag")
	private String urlFlag;
	
}
