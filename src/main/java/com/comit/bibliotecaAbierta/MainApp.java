package com.comit.bibliotecaAbierta;

import com.comit.bibliotecaAbierta.modelo.Admin;
import com.comit.bibliotecaAbierta.modelo.User;

public class MainApp {

	public static void main(String[] args) {
	
		User u = new User("Pepito", "pepitouwu@gmail.com");
		u.setBiography("Esta es la biografia de Pepito");
		
		System.out.println(u);

	}

}
