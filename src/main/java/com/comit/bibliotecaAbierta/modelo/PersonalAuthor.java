package com.comit.bibliotecaAbierta.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("PERSONAL_AUTHOR")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PersonalAuthor implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String lastName;
	private String fechaNyM;
	private String rol;
	private String biography;
	
	@ManyToMany
	private Set<Text> text;
	
}
