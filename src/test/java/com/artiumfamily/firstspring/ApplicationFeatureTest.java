package com.artiumfamily.firstspring;

import com.artiumfamily.firstspring.models.PokemonDTO;
import com.artiumfamily.firstspring.models.Type;
import com.artiumfamily.firstspring.models.TypeListElement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ApplicationFeatureTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RestTemplate restTemplate;


    @Test
    void testTheWholeThing() throws Exception {

        PokemonDTO pikachuJson = PokemonDTO.builder()
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

        when(restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/pikachu", PokemonDTO.class))
                .thenReturn(pikachuJson);

        mockMvc.perform(get("/pokemon/pikachu"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("pikachu"));

        verify(restTemplate, times(1))
                .getForObject("https://pokeapi.co/api/v2/pokemon/pikachu", PokemonDTO.class);
    }
}
