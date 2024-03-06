package com.artiumfamily.firstspring.controllers;

import com.artiumfamily.firstspring.models.Pokemon;
import com.artiumfamily.firstspring.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    /**
     *  Autowired starts with the application to build the graph of beans across the application
     *  This is essentially "instantiating" the service, adding it to the container
     *  Spring is looking at the classname of the variable -- may or may not work at all times
     *  If it can't use the classname alone, it will use the variable name, or you can google how to customize it
    **/
    @Autowired PokemonService service;

    @GetMapping(value = "/")
    public String getAllPokemon() {
        return service.getAllPokemon();
    }


    @GetMapping("/pokemon/{name}")
    public Pokemon getPokemonByName(@PathVariable String name) {
        return service.getPokemonByName(name);
    }
}
