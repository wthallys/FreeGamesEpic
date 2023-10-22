package com.wthallys.freeGamesEpic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TotalPrice {
    @JsonProperty("fmtPrice")
    private FmtPrice fmtPrice;
}
