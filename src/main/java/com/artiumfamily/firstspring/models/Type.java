package com.artiumfamily.firstspring.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Type {
    private String name;
    private String url;
}
