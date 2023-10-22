package com.wthallys.freeGamesEpic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Catalog {
    @JsonProperty("searchStore")
    private SearchStore searchStore;
}
