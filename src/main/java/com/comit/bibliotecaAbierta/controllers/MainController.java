package com.comit.bibliotecaAbierta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/subir-texto")
		public String subirTexto() {
			return "uploadText";
		}
	
	}
