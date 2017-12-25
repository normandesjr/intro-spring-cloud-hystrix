package com.hibicode.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.hibicode.model.Word;

@FeignClient("ARTICLE")
public interface ArticleClient {

	@GetMapping("/")
	public Word getWord();
	
}
