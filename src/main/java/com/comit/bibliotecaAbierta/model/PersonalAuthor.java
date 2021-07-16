package com.comit.bibliotecaAbierta.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("PERSONAL_AUTHOR")
@Getter
@Setter
@NoArgsConstructor
public class PersonalAuthor extends Author implements Serializable{
	private static final long serialVersionUID = 1L;

	private String fechaNyM;
	private String biography;
	
}
