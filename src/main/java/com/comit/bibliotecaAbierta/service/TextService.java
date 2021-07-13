package com.comit.bibliotecaAbierta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comit.bibliotecaAbierta.model.Author;
import com.comit.bibliotecaAbierta.model.Text;
import com.comit.bibliotecaAbierta.repositories.TextRepository;

@Service
public class TextService {

		private final TextRepository textRepository;

		@Autowired
		public TextService(TextRepository textRepository) {
			this.textRepository = textRepository;
		}

		public Text saveText(Text text) {
			return textRepository.saveAndFlush(text);
		}

		public List<Text> listTexts() {
			return textRepository.findAll();
		}
	}
