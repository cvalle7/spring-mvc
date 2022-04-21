package com.formacion.nttdata.pokeapi.dao;

import com.formacion.nttdata.pokeapi.Movimiento;
import com.formacion.nttdata.pokeapi.Pokemon;

public interface PokemonDao {
	public Pokemon getPokemonById(String id);
    public Movimiento getMovimientoById(String id);
    public Pokemon getImgById(String id);

}
