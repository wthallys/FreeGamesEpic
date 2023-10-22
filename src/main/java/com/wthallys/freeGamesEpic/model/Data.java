package com.wthallys.freeGamesEpic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class Data {
    @JsonProperty("Catalog")
    private Catalog catalog;
}
