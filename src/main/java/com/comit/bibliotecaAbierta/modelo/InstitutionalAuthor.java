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
@DiscriminatorValue("INSTITUTIONAL_AUTHOR")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class InstitutionalAuthor implements Serializable{
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String jurisdiction;
	private String name;
	
	@ManyToMany
	private Set<Text> text;
}