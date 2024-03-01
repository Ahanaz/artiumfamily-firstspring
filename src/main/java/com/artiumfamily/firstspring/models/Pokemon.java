package com.artiumfamily.firstspring.models;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Pokemon {

    private String name;

    private String elementType;

    public Pokemon(String name) {
        this.name = name;
    }

    public Pokemon(String name, String type) {
        this.name = name;
        this.elementType = type;
    }
}
