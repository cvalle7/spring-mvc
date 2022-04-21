package com.formacion.nttdata.pokeapi;

import javax.json.bind.annotation.JsonbProperty;

public class Pokemon {
    
    @JsonbProperty
    private String name;
    
    @JsonbProperty
    private String weight;
    
    @JsonbProperty
    private String height;
    
    @JsonbProperty("base_experience")
    private String baseExperience;
    
    private String img;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getBaseExperience() {
		return baseExperience;
	}

	public void setBaseExperience(String baseExperience) {
		this.baseExperience = baseExperience;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
    
	
	
}
