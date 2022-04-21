package com.formacion.nttdata.pokeapi;

import javax.json.bind.annotation.JsonbProperty;

public class Movimiento {
	@JsonbProperty
    private String name;
    
    @JsonbProperty
    private String accuracy;
    
    @JsonbProperty
    private String pp;
    
    @JsonbProperty
    private String priority;
    
    @JsonbProperty
    private String power;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }  

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

}
