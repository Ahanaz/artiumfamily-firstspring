package com.artiumfamily.firstspring.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {

    @InjectMocks PokemonService service;

    @Test
    void getAllPokemon_returnsArrayOfPokemon_onSuccess() {
        /**
         * Returns the string 'Pikachu'
         */

        assertEquals("Pikachu", service.getAllPokemon());
    }
}