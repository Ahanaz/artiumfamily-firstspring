package com.artiumfamily.firstspring.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TypeListElement {
    private Integer slot;
    private Type type;
}
