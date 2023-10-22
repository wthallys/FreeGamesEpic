package com.wthallys.freeGamesEpic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class GameData {
    @JsonProperty("data")
    private Data data;
}
