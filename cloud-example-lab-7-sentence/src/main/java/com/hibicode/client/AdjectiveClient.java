package com.hibicode.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.hibicode.model.Word;

@FeignClient("ADJECTIVE")
public interface AdjectiveClient {

	@GetMapping("/")
	public Word getWord();
	
}
