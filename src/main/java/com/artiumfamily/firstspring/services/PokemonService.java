package com.artiumfamily.firstspring.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
    public String getAllPokemon(){
        return "Pikachu";
    }
}
