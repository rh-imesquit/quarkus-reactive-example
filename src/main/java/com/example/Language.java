package com.example;

import jakarta.validation.constraints.NotNull;

public class Language {
    
    @NotNull
    private String type;
    
    @NotNull
    private String name;

    public Language() {

    }

    public Language(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
