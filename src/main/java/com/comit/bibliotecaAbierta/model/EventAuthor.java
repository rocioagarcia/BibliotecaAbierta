package com.comit.bibliotecaAbierta.model;

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
@DiscriminatorValue("EVENT_AUTHOR")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class EventAuthor extends Author implements Serializable{
	private static final long serialVersionUID = 1L;

	private String name;
	private String number;
	private String place;
	
	@ManyToMany
	private Set<Text> text;
}
