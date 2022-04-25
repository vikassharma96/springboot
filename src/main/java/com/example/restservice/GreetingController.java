package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// classes which Spring search for to find @GetMapping
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	/*
	There is no relationship between function name and end point URL.
	@GetMapping annotation is the one that decides the URL.
	 */
	@GetMapping("/learningisdoing")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		System.out.println("Learn By Doing");
		Greeting greetingMessage = new Greeting(counter.incrementAndGet(), String.format(template, name));
		return greetingMessage;
	}

	@PostMapping("/json-request")
	public String processJson(@RequestBody CreditCard creditCard) {
		System.out.println("Thank you for providing your credit card details."
			+ "We promise to take care of all your purchases from now on ;-) ");
		System.out.println(creditCard);
		return "You are the true Santa";
	}

	// Handy curl request.
	// curl --header "Content-Type: application/json" \
	//   --request POST \
	//   --data '{"name":"Santa","creditCardNumber":"0202-2323-2323-1999"}' \
	//   http://localhost:8081/json-request
}

/*
Jackson + Spring Magic
Jackson is a java library that helps you convert a Java object into JSON and back.
Whenever required Spring automagically uses Jackson library to convert Java objects
into JSON and back. It uses a class in Jackson library called ObjectMapper to do this.
 */
