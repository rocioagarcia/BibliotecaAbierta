package com.comit.bibliotecaAbierta.model;

import java.io.Serializable;
import java.util.Set;

//import javax.persistence.JoinColumn ;
//import javax.persistence.CollectionTable;
//import javax.persistence.Column;
//import javax.persistence.ElementCollection;
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
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Text implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToMany
	private Set<Author> author;
	private String title;
	private String paralelTitle;
	private String alternativeTitle;
	private String subtitle;
	private String variantTitle;
	private String dgm;
	private String edition;
	private String editor;
	private String publicationDate;
	private Integer extention;
	private String details;
	private String notes;
	@ManyToMany
	private Set<Subject> subjects;
	@ManyToMany
	private Set<Review> review;
	private String file;


}
