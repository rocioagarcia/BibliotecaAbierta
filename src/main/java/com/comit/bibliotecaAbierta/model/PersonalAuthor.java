package com.comit.bibliotecaAbierta.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

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

	private String name;
	private String fechaNyM;
	private String biography;
	
}
