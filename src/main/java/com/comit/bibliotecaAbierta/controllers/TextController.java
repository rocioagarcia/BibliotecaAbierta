package com.comit.bibliotecaAbierta.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.comit.bibliotecaAbierta.model.Author;
import com.comit.bibliotecaAbierta.model.Editor;
import com.comit.bibliotecaAbierta.model.Subject;
import com.comit.bibliotecaAbierta.model.Text;
import com.comit.bibliotecaAbierta.service.TextService;

@Controller
@RequestMapping("/text")
public class TextController {

	private final TextService textService;

	public TextController(TextService textService) {
		this.textService = textService;
	}

	@RequestMapping(value = "/subir", method = RequestMethod.GET)
	public String uploadText(Model model) {
		model.addAttribute("text", new Text());
		return "uploadText";
	}

	// A esto agregar despues: 
	// @RequestParam(value = "author") Set<Author> author,
	// @RequestParam(value = "editor") Set<Editor> editor,
	// @RequestParam(value = "subjects") Set<Subject> subjects,

	@PostMapping(value = "/crear")
	public String createText(@RequestParam(value = "title") String title,
			@RequestParam(value = "paralelTitle") String paralelTitle,
			@RequestParam(value = "alternativeTitle") String alternativeTitle,
			@RequestParam(value = "subtitle") String subtitle,
			@RequestParam(value = "variantTitle") String variantTitle, @RequestParam(value = "dgm") String dgm,
			@RequestParam(value = "edition") String edition,
			@RequestParam(value = "publicationDate") String publicationDate,
			@RequestParam(value = "extention") Integer extention, @RequestParam(value = "details") String details,
			@RequestParam(value = "notes") String notes, 
			@RequestParam(value = "file") String file, Model model) {

		Text text = new Text();
//		text.setAuthor(author);
		text.setTitle(title);
		text.setParalelTitle(paralelTitle);
		text.setAlternativeTitle(alternativeTitle);
		text.setSubtitle(subtitle);
		text.setVariantTitle(variantTitle);
		text.setDgm(dgm);
		text.setEdition(edition);
//		text.setEditor(editor);
		text.setPublicationDate(publicationDate);
		text.setExtention(extention);
		text.setDetails(details);
		text.setNotes(notes);
//		text.setSubjects(subjects);
		text.setFile(file);

		text = textService.guardar(text);
		System.out.println(String.format("Se creo el text con id: %s ", text.getId()));
		model.addAttribute("text", text);
		return "seeText";
	}
}
