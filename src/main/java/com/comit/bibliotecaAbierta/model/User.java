package com.comit.bibliotecaAbierta.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@DiscriminatorValue("USUARIO")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private Long id;
	private String username;
	private String profilePic;
	private String biography;
	private String email;
	private String rol = "USER";
	@OneToMany	
	private Set<TextList> textList;
	@OneToMany
	private Set<Review> review;
	
	
	 

	
}
