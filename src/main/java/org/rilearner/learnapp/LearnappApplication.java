package org.rilearner.learnapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LearnappApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnappApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam(name =  "myName") String myName) {
		return String.format("Hey Der %s! ", myName);
	}
}
