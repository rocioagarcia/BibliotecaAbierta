package com.comit.bibliotecaAbierta.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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

	private String number;
	private String jurisdiction;

}
