package com.wthallys.freeGamesEpic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Element {
    @JsonProperty("price")
    private Price price;
    private String title;
    private String description;
}
