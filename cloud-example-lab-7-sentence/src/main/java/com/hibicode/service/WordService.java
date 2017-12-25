package com.hibicode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibicode.client.AdjectiveClient;
import com.hibicode.client.ArticleClient;
import com.hibicode.client.NounClient;
import com.hibicode.client.SubjectClient;
import com.hibicode.client.VerbClient;
import com.hibicode.model.Word;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class WordService {

	@Autowired
	private VerbClient verbClient;

	@Autowired
	private SubjectClient subjectService;

	@Autowired
	private ArticleClient articleService;

	@Autowired
	private AdjectiveClient adjectiveService;

	@Autowired
	private NounClient nounService;

	public Word getVerb() {
		return verbClient.getWord();
	}

	@HystrixCommand(fallbackMethod="getFallbackSubject")
	public Word getSubject() {
		return subjectService.getWord();
	}

	public Word getArticle() {
		return articleService.getWord();
	}

	@HystrixCommand(fallbackMethod="getFallbackAdjective")
	public Word getAdjective() {
		return adjectiveService.getWord();
	}

	@HystrixCommand(fallbackMethod="getFallbackNoun")
	public Word getNoun() {
		return nounService.getWord();
	}
	
	public Word getFallbackAdjective() {
		return new Word("");
	}
	public Word getFallbackSubject() {
		return new Word("Someone");
	}
	public Word getFallbackNoun() {
		return new Word("something");
	}

}
