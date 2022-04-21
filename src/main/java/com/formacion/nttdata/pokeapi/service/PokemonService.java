package com.formacion.nttdata.pokeapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.nttdata.pokeapi.Movimiento;
import com.formacion.nttdata.pokeapi.Pokemon;
import com.formacion.nttdata.pokeapi.dao.PokemonDao;

@Service
public class PokemonService {

	@Autowired
	private PokemonDao dao;

	public Pokemon getPokemon(String id) {
		return dao.getPokemonById(id);
	}

	public Movimiento getMovimiento(String id) {
		return dao.getMovimientoById(id);
	}

	public Pokemon postPokemon(Pokemon pokemon) {
		return pokemon;
	}
	
	public Pokemon getImg(String id) {
		return dao.getImgById(id);
	}

}