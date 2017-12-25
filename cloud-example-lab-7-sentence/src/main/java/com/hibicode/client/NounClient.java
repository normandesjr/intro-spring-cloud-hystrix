package com.hibicode.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.hibicode.model.Word;

@FeignClient("NOUN")
public interface NounClient {

	@GetMapping("/")
	public Word getWord();
	
}
