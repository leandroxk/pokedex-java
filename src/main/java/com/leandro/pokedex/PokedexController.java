package com.leandro.pokedex;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokedexController {
	
	private Pokedex pokedex;

	public PokedexController() {
		pokedex = new Pokedex();
	}
	
	@RequestMapping("/search")
	public Pokemon search(
			@RequestParam(value="number", defaultValue="") Integer number, 
			@RequestParam(value="name", defaultValue="") String name) {
		
		return pokedex.search(number, name);
	}
}