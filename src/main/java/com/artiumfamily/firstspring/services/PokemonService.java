package com.artiumfamily.firstspring.services;

import com.artiumfamily.firstspring.models.Pokemon;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
    public String getAllPokemon(){
        return "Pikachu";
    }

    public Pokemon getPokemonByName(String name) {

        Pokemon pikachu = Pokemon.builder()
                .name("pikachu")
                .elementType("electric")
                .build();

        return pikachu;
    }
}
