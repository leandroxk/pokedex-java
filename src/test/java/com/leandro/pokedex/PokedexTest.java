package com.leandro.pokedex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class PokedexTest {

	@Test
	public void helloWord() {
		Pokemon pokemon = new Pokedex().search(10, "");
		
		assertNotNull(pokemon.getName());
		assertNotNull(pokemon.getNumber());
		assertEquals("Caterpie", pokemon.getName());
		assertEquals(10L, pokemon.getNumber().longValue());
	}
	
	@Test
	public void searchByNameTest() {
		Pokemon pokemon = new Pokedex().search(0, "Eevee");
		
		assertNotNull(pokemon.getName());
		assertNotNull(pokemon.getNumber());
		assertEquals("Eevee", pokemon.getName());
		assertEquals(133L, pokemon.getNumber().longValue());
	}
	
	@Test
	public void invalidPokemonTest() {
		Pokemon pokemon = new Pokedex().search(0, "ABCD");
		
		assertFalse(pokemon.isValid());
		assertNull(pokemon.getName());
		assertNull(pokemon.getNumber());
	}
	
}
