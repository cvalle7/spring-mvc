package com.formacion.nttdata.pokeapi.dao;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.formacion.nttdata.pokeapi.Movimiento;
import com.formacion.nttdata.pokeapi.Pokemon;


@Service
public class PokemonDaoImp implements PokemonDao {

    private Client client;
    private WebTarget getPokemon;
    private WebTarget getMovimiento;
    private static final String URL_POKEMON = "https://pokeapi.co/api/v2/pokemon/{id}";
    private static final String URL_MOVIMIENTO = "https://pokeapi.co/api/v2/move/{id}";
    
    public PokemonDaoImp() {
    	
        this.client = ClientBuilder.newBuilder().build();
        this.getPokemon = client.target(URL_POKEMON);
        this.getMovimiento = client.target(URL_MOVIMIENTO);
    }

    @Override
    public Pokemon getPokemonById(String id) {

        Response response = getPokemon.resolveTemplate("id", id)
                                      .request(MediaType.APPLICATION_JSON)
                                      .get();

        switch (response.getStatus()) {
            case 200:
                Pokemon p = response.readEntity(Pokemon.class);
                return p;
            default:
                return null;
        }

    }

    @Override
    public Movimiento getMovimientoById(String id) {
        Response response = getMovimiento.resolveTemplate("id", id)
                                         .request(MediaType.APPLICATION_JSON)
                                         .get();

        switch (response.getStatus()) {
            case 200:
                Movimiento m = response.readEntity(Movimiento.class);
                return m;
            default:
                return null;
        }
    }

	@Override
	public Pokemon getImgById(String id) {
		
		Response response = getPokemon.resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get();
		String p = response.readEntity(String.class);
		JSONParser parser = new JSONParser();
		JSONObject object = new JSONObject();
		JSONObject objectName = new JSONObject();
		
		try {
			object = (JSONObject) parser.parse(p);
			objectName = (JSONObject) parser.parse(p);
			JSONObject jo = (JSONObject) object.get("sprites");
			Pokemon po = new Pokemon();
			po.setImg(jo.get("front_default").toString());
			po.setName(objectName.get("name").toString());
			po.setBaseExperience(objectName.get("base_experience").toString());
			po.setHeight(objectName.get("height").toString());
			po.setWeight(objectName.get("weight").toString());
			return po;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    
}



