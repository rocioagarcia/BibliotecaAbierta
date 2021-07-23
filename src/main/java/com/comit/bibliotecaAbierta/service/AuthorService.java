package com.comit.bibliotecaAbierta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comit.bibliotecaAbierta.model.Author;
import com.comit.bibliotecaAbierta.model.EventAuthor;
import com.comit.bibliotecaAbierta.model.InstitutionalAuthor;
import com.comit.bibliotecaAbierta.model.PersonalAuthor;
import com.comit.bibliotecaAbierta.repositories.AuthorRepository;
import com.comit.bibliotecaAbierta.repositories.EventAuthorRepository;
import com.comit.bibliotecaAbierta.repositories.InstitutionalAuthorRepository;
import com.comit.bibliotecaAbierta.repositories.PersonalAuthorRepository;

@Service
public class AuthorService {

	private final AuthorRepository authorRepository;
	private final PersonalAuthorRepository personalAuthorRepository;
	private final InstitutionalAuthorRepository institutionalAuthorRepository;
	private final EventAuthorRepository eventAuthorRepository;

	@Autowired
	public AuthorService(AuthorRepository authorRepository, PersonalAuthorRepository personalAuthorRepository,
			InstitutionalAuthorRepository institutionalAuthorRepository, EventAuthorRepository eventAuthorRepository) {
		this.authorRepository = authorRepository;
		this.personalAuthorRepository = personalAuthorRepository;
		this.institutionalAuthorRepository = institutionalAuthorRepository;
		this.eventAuthorRepository = eventAuthorRepository;
	}

	public PersonalAuthor guardarPersonal(PersonalAuthor personalAuthor) {
		return personalAuthorRepository.saveAndFlush(personalAuthor);
	}

	public InstitutionalAuthor guardarInstitutional(InstitutionalAuthor institutionalAuthor) {
		return institutionalAuthorRepository.saveAndFlush(institutionalAuthor);
	}

	public EventAuthor guardarEvent(EventAuthor eventAuthor) {
		return eventAuthorRepository.saveAndFlush(eventAuthor);
	}

	public List<Author> listAuthors() {
		return authorRepository.findAllByOrderByNameAsc();
	}
}
