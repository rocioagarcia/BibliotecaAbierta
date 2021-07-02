package com.comit.bibliotecaAbierta.modelo;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Admin extends User{
	private static final long serialVersionUID = 1L;
	
	public Admin(String username, String email) {
		super(username, email);
	}

	

}
