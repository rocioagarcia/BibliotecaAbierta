package com.comit.bibliotecaAbierta.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.comit.bibliotecaAbierta.model.Author;
import com.comit.bibliotecaAbierta.model.Subject;
import com.comit.bibliotecaAbierta.model.Text;
import com.comit.bibliotecaAbierta.service.AuthorService;
import com.comit.bibliotecaAbierta.service.SubjectService;
import com.comit.bibliotecaAbierta.service.TextService;

@Controller
@RequestMapping("/texto")
public class TextController {

	private final TextService textService;
	private final AuthorService authorService;
	private final SubjectService subjectService;

	public TextController(TextService textService, AuthorService authorService, SubjectService subjectService) {
		this.textService = textService;
		this.authorService = authorService;
		this.subjectService = subjectService;
	}

//CREAR TEXTO
	@RequestMapping(value = "/subir", method = RequestMethod.GET)
	public String uploadText(Model model) {
		model.addAttribute("text", new Text());

		List<Author> authorList = authorService.listAuthors();
		model.addAttribute("authorList", authorList);
		return "uploadText";
	}

	@PostMapping(value = "/crear")
	public String createText(@RequestParam(value = "author") Set<Author> author,
			@RequestParam(value = "title") String title, @RequestParam(value = "photo") String photo,
			@RequestParam(value = "paralelTitle") String paralelTitle,
			@RequestParam(value = "alternativeTitle") String alternativeTitle,
			@RequestParam(value = "subtitle") String subtitle,
			@RequestParam(value = "variantTitle") String variantTitle, @RequestParam(value = "dgm") String dgm,
			@RequestParam(value = "editor") String editor, @RequestParam(value = "edition") String edition,
			@RequestParam(value = "publicationDate") String publicationDate,
			@RequestParam(value = "extention") Integer extention, @RequestParam(value = "details") String details,
			@RequestParam(value = "notes") String notes, @RequestParam(value = "subjects") String subjects,
			@RequestParam(value = "file") String file, Model model) {

		Text text = new Text();
		text.setAuthor(author);
		text.setPhoto(photo);
		text.setTitle(title);
		text.setParalelTitle(paralelTitle);
		text.setAlternativeTitle(alternativeTitle);
		text.setSubtitle(subtitle);
		text.setVariantTitle(variantTitle);
		text.setDgm(dgm);
		text.setEdition(edition);
		text.setEditor(editor);
		text.setPublicationDate(publicationDate);
		text.setExtention(extention);
		text.setDetails(details);
		text.setNotes(notes);
		text.setFile(file);

		String[] split = subjects.split(",");
		Set<Subject> subjectCollection = subjectService.giveSubjects(split);

		text.setSubjects(subjectCollection);

		text = textService.saveText(text);
		System.out.println(String.format("Se creo el text con id: %s ", text.getId()));
		model.addAttribute("text", text);
		return "redirect:/texto/" + text.getId();
	}

	// BUSCAR
	@PostMapping(value = "/busqueda")
	public String searchText(@RequestParam(value = "search") String search, Model model) {
		List<Text> searchResults = textService.searchBar(search);
		System.out.println("La lista de textos compatibles tiene:" + searchResults);
		model.addAttribute("text", searchResults);
		return "catalog";
	}
	
// CATALOGO Y VISTAS ESPECIFICAS
	@RequestMapping(value = "/catalogo", method = RequestMethod.GET)
	public String catalog(Model model) {
		model.addAttribute("text", textService.listTexts());
		return "catalog";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String seeText(Model model, @PathVariable(value = "id") Long id) {
//		if ((textService.findText(id)) == null){
//			return "error";
//		} else {
		model.addAttribute("text", textService.findText(id));
		return "textById";
	}

//	EDICION
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public String editText(Model model, @PathVariable(value = "id") Long id) {
		String subjects = "";
		Text text = textService.findText(id);
		model.addAttribute("text", text);

		Set<Subject> oldSubjects = text.getSubjects();
		for (Subject subj : oldSubjects) {
			subjects = subjects + "," + subj.getName();
		}
		model.addAttribute("subjectsForShow", subjects);

		List<Author> authorList = authorService.listAuthors();
		model.addAttribute("authorList", authorList);
		return "updateText";
	}

	@PostMapping("/update/{id}")
	public String updateText(@PathVariable(value = "id") Long id, @RequestParam(value = "author") Set<Author> author,
			@RequestParam(value = "title") String title, @RequestParam(value = "photo") String photo,
			@RequestParam(value = "paralelTitle") String paralelTitle,
			@RequestParam(value = "alternativeTitle") String alternativeTitle,
			@RequestParam(value = "subtitle") String subtitle,
			@RequestParam(value = "variantTitle") String variantTitle, @RequestParam(value = "dgm") String dgm,
			@RequestParam(value = "editor") String editor, @RequestParam(value = "edition") String edition,
			@RequestParam(value = "publicationDate") String publicationDate,
			@RequestParam(value = "extention") Integer extention, @RequestParam(value = "details") String details,
			@RequestParam(value = "notes") String notes, @RequestParam(value = "file") String file,
			@RequestParam(value = "subjectsForShow") String subjects, Text text, Model model) {

		text = textService.findText(id);

		text.setAuthor(author);
		text.setPhoto(photo);
		text.setTitle(title);
		text.setParalelTitle(paralelTitle);
		text.setAlternativeTitle(alternativeTitle);
		text.setSubtitle(subtitle);
		text.setVariantTitle(variantTitle);
		text.setDgm(dgm);
		text.setEdition(edition);
		text.setEditor(editor);
		text.setPublicationDate(publicationDate);
		text.setExtention(extention);
		text.setDetails(details);
		text.setNotes(notes);
		text.setFile(file);

		String[] split = subjects.split(",");
		Set<Subject> subjectCollection = subjectService.giveSubjects(split);

		text.setSubjects(subjectCollection);

		text = textService.saveText(text);
		System.out.println(String.format("Se editó el text con id: %s ", text.getId()));
		model.addAttribute("text", text);
		return "redirect:/texto/" + text.getId();
	}

	// BORRAR
	@RequestMapping(value = "/borrar/{id}", method = RequestMethod.GET)
	public String deleteText(@PathVariable(value = "id") Long id, Model model) {
		Text text = textService.findText(id);
		textService.deleteById(text);
		return "redirect:/";
	}
}
