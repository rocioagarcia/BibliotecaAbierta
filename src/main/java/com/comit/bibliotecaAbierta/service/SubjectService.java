package com.comit.bibliotecaAbierta.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comit.bibliotecaAbierta.model.Subject;

import com.comit.bibliotecaAbierta.repositories.SubjectRepository;

@Service
public class SubjectService {

	private final SubjectRepository subjectRepository;

	@Autowired
	public SubjectService(SubjectRepository subjectRepository) {
		this.subjectRepository = subjectRepository;
	}

	public Subject saveSubject(Subject subject) {
		return subjectRepository.saveAndFlush(subject);
	}

	public List<Subject> findSubjects() {
		return subjectRepository.findAll();
	}

	public Subject findOneBySubject(String s) {
		Subject subject = subjectRepository.findOneBySubject(s);

		if (subject == null) {
			Subject sub = new Subject(s);
			saveSubject(sub);
			return sub;
		} else {
			return subject;
		}
	}

	public Set<Subject> giveSubjects(String[] split) {
		Set<Subject> subjectCollection = new HashSet<Subject>();
		Subject subject;

		for (String s : split) {
			subject = findOneBySubject(s);
			subjectCollection.add(subject);
		}

		return subjectCollection;
	}

}
