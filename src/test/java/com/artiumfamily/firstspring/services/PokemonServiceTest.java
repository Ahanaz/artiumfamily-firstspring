package com.artiumfamily.firstspring.services;

import com.artiumfamily.firstspring.models.Pokemon;
import com.artiumfamily.firstspring.models.PokemonDTO;
import com.artiumfamily.firstspring.models.Type;
import com.artiumfamily.firstspring.models.TypeListElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {

    public static final String POKEAPI_PIKACHU_URL = "https://pokeapi.co/api/v2/pokemon/pikachu";
    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    PokemonService service;

    @Test
    void getAllPokemon_returnsArrayOfPokemon_onSuccess() {
        assertEquals("Pikachu", service.getAllPokemon());
    }

    @Test
    void getPokemonByName_returnsPokemon_onSuccess() {
        PokemonDTO mockedPikachuDto = PokemonDTO.builder()
                .name("pikachu")
                .types(List.of(
                        TypeListElement.builder()
                            .type(Type.builder()
                                    .name("electric")
                                    .build())
                            .build()
                    )
                )
                .build();

        Pokemon pikachu = Pokemon.builder()
                .name("pikachu")
                .elementType("electric")
                .build();

        when(restTemplate.getForObject(
                POKEAPI_PIKACHU_URL,
                PokemonDTO.class)
        ).thenReturn(mockedPikachuDto);

        assertEquals(pikachu, service.getPokemonByName("pikachu"));
    }
}
