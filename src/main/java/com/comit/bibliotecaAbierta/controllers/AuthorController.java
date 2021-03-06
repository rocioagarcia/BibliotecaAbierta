package com.comit.bibliotecaAbierta.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.comit.bibliotecaAbierta.model.EventAuthor;
import com.comit.bibliotecaAbierta.model.InstitutionalAuthor;
import com.comit.bibliotecaAbierta.model.PersonalAuthor;
import com.comit.bibliotecaAbierta.service.AuthorService;

@Controller
@RequestMapping("/autor")
public class AuthorController {

	private final AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	// UPLOAD PERSONAL AUTHOR
	@RequestMapping(value = "/personal/subir", method = RequestMethod.GET)
	public String uploadPersonalAuthor(Model model, HttpServletRequest request) {
		model.addAttribute("personalAuthor", new PersonalAuthor());

		String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		String referer = request.getHeader("Referer");
		model.addAttribute("redirect", referer.replace(contextPath, ""));

		return "uploadPersonalAuthor2";
	}

	@PostMapping(value = "/personal/crear")
	public String createPersonalAuthor(@RequestParam(value = "name") String name,
			@RequestParam(value = "fechaNyM") String fechaNyM, @RequestParam(value = "biography") String biography,
			@RequestParam(value = "redirect") String redirect, Model model) {

		PersonalAuthor personalAuthor = new PersonalAuthor();
		personalAuthor.setName(name);
		personalAuthor.setFechaNyM(fechaNyM);
		personalAuthor.setBiography(biography);

		personalAuthor = authorService.guardarPersonal(personalAuthor);
		System.out.println(String.format("Se creo el autor con id: %s ", personalAuthor.getId()));
		model.addAttribute("personalAuthor", personalAuthor);
		return "redirect:" + redirect;
	}

	// UPLOAD INSTITUTIONAL AUTHOR
	@RequestMapping(value = "/entidades-etc/subir", method = RequestMethod.GET)
	public String uploadInstitutionalAuthor(Model model, HttpServletRequest request) {
		model.addAttribute("institutionalAuthor", new InstitutionalAuthor());

		String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		String referer = request.getHeader("Referer");
		model.addAttribute("redirect", referer.replace(contextPath, ""));
		return "uploadInstitutionalAuthor";
	}

	@PostMapping(value = "/entidades-etc/crear")
	public String createInstitutionalAuthor(@RequestParam(value = "jurisdiction") String jurisdiction,
			@RequestParam(value = "name") String name, @RequestParam(value = "redirect") String redirect, Model model) {

		InstitutionalAuthor institutionalAuthor = new InstitutionalAuthor();
		institutionalAuthor.setJurisdiction(jurisdiction);
		institutionalAuthor.setName(name);

		institutionalAuthor = authorService.guardarInstitutional(institutionalAuthor);
		System.out.println(String.format("Se creo el autor con id: %s ", institutionalAuthor.getId()));
		model.addAttribute("institutionalAuthor", institutionalAuthor);
		return "redirect:" + redirect;
	}

	// UPLOAD EVENT AUTHOR
	@RequestMapping(value = "/reuniones-etc/subir", method = RequestMethod.GET)
	public String uploadEventAuthor(Model model, HttpServletRequest request) {
		model.addAttribute("eventAuthor", new EventAuthor());

		String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		String referer = request.getHeader("Referer");
		model.addAttribute("redirect", referer.replace(contextPath, ""));
		return "uploadEventAuthor";
	}

	@PostMapping(value = "/reuniones-etc/crear")
	public String createEventAuthor(@RequestParam(value = "name") String name,
			@RequestParam(value = "number") String number, @RequestParam(value = "place") String jurisdiction,
			@RequestParam(value = "redirect") String redirect, Model model) {

		EventAuthor eventAuthor = new EventAuthor();

		eventAuthor.setName(name);
		eventAuthor.setNumber(number);
		eventAuthor.setJurisdiction(jurisdiction);

		eventAuthor = authorService.guardarEvent(eventAuthor);
		System.out.println(String.format("Se creo el autor con id: %s ", eventAuthor.getId()));
		model.addAttribute("eventAuthor", eventAuthor);
		return "redirect:" + redirect;
	}
}
