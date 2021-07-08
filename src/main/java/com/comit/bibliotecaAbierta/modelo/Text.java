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
	private PersonalAuthor personalAuthor;
	@ManyToMany
	private InstitutionalAuthor institutionalAuthor;
	@ManyToMany
	private EventAuthor eventAuthor;
	private String title;
	private String paralelTitle;
	private String alternativeTitle;
	private String subtitle;
	private String variantTitle;
	private String dgm;
	private String edition;
	@ManyToMany
	private Editor editor;
	private String publicationDate;
	private Integer extention;
	private String details;
	private String notes;
	@ManyToMany
	private Subject subject;
	@OneToMany
	private Review review;
	private String file;
	
	public Text(String title, String edition, String publicationDate, Integer extention) {
		this.title = title;
		this.edition = edition;
		this.publicationDate = publicationDate;
		this.extention = extention;
	}
 }
 
