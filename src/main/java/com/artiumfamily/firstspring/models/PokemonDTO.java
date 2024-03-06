package com.artiumfamily.firstspring.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class PokemonDTO {
    private String name;
    private List<TypeListElement> types;
}
