package com.formacion.nttdata.pokeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.nttdata.pokeapi.Movimiento;
import com.formacion.nttdata.pokeapi.Pokemon;
import com.formacion.nttdata.pokeapi.service.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	PokemonService pokemonService;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			     produces = { MediaType.APPLICATION_JSON_VALUE })
	public Pokemon postPokemon(@RequestBody Pokemon pokemon) {
		return pokemonService.postPokemon(pokemon);
	}

	@GetMapping(value = "/{id}")
	public Pokemon showPokemon(@PathVariable String id) {
		return pokemonService.getPokemon(id);
	}

	@GetMapping(value = "move/{id}")
	public Movimiento showMovement(@PathVariable String id) {
		return pokemonService.getMovimiento(id);
	}
	
	@GetMapping(value = "img/{id}")
	public Pokemon showImg(@PathVariable String id) {
		return pokemonService.getImg(id);
	}

}