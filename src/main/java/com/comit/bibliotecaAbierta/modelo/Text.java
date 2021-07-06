package com.comit.bibliotecaAbierta.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

 @Entity
 @Getter
 @Setter
 @NoArgsConstructor
 @ToString
public class Text implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@ManyToMany
	private Set<PersonalAuthor> personalAuthor;
	@ManyToMany
	private Set<InstitutionalAuthor> institutionalAuthor;
	@ManyToMany
	private Set<EventAuthor> eventAuthor;
	private String title;
	private String paralelTitle;
	private String alternativeTitle;
	private String subtitle;
	private String variantTitle;
	private String dgm;
	private String edition;
	@ManyToMany
	private Set<Editor> editor;
	private String publicationPlace;
	private String publicationDate;
	private int extention;
	private String details;
	private String notes;
	@ManyToMany
	private Set<Subject> subject;
	@OneToMany
	private Set <Review> review;
	private String downloable;
	
}
