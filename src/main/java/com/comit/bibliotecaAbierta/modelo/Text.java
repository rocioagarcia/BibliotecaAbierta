package com.comit.bibliotecaAbierta.modelo;

import java.io.Serializable;
import java.util.List;
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
	private Set<Author> author;
	private String title;
	private String edition;
	private String dgm;
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
	private Review review;
	@ManyToMany
	private List <TextList> textList;
	private String downloable;
	
	public Text (Set<Author> author, String title, String edition, String publicationDate, int extention, String downloable) {
		this.author = author;
		this.title = title;
		this.edition = edition;
		this.publicationDate = publicationDate;
		this.extention = extention;
		this.downloable = downloable;
	}
}
