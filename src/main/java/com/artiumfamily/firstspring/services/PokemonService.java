package com.artiumfamily.firstspring.services;

import com.artiumfamily.firstspring.models.Pokemon;
import com.artiumfamily.firstspring.models.PokemonDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService  {

    RestTemplate restTemplate;

    public static final String POKEAPI_PIKACHU_URL = "https://pokeapi.co/api/v2/pokemon/pikachu";

    public String getAllPokemon(){
        return "Pikachu";
    }

    public Pokemon getPokemonByName(String name) {
        restTemplate.getForObject(
                POKEAPI_PIKACHU_URL,
                PokemonDTO.class);

        Pokemon pikachu = Pokemon.builder()
                .name("pikachu")
                .elementType("electric")
                .build();

        return pikachu;
    }
}
