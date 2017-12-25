package com.hibicode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hibicode.service.SentenceService;

@RestController
public class SentenceController {

	@Autowired
	private SentenceService sentenceService;

	@GetMapping("/sentence")
	public @ResponseBody String getSentence() {
		return sentenceService.buildSentence();
	}
}
