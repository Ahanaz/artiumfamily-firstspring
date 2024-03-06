package com.artiumfamily.firstspring.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
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
