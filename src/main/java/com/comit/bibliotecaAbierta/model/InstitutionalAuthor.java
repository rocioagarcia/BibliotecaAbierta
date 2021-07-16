package com.comit.bibliotecaAbierta.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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
public class InstitutionalAuthor extends Author implements Serializable{
	private static final long serialVersionUID = 1L;

	private String jurisdiction;
	
}
