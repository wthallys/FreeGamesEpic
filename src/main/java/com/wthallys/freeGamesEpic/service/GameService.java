package com.wthallys.freeGamesEpic.service;

import com.wthallys.freeGamesEpic.model.Element;
import com.wthallys.freeGamesEpic.model.ElementInfo;
import com.wthallys.freeGamesEpic.model.GameData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class GameService {
    @Autowired
    RestTemplate restTemplate;

    public List<ElementInfo> getFilteredElements() {
        String url = "https://store-site-backend-static-ipv4.ak.epicgames.com/freeGamesPromotions?locale=pt-BR&country=BR&allowCountries=BR";
        GameData gameData = restTemplate.getForObject(url, GameData.class);

        List<Element> elements = gameData.getData().getCatalog().getSearchStore().getElements();

        List<ElementInfo> filteredElements = elements.stream()
                .filter(element -> "0".equals(element.getPrice().getTotalPrice().getFmtPrice().getIntermediatePrice()))
                .map(element -> new ElementInfo(element.getTitle(), element.getDescription()))
                .collect(Collectors.toList());

        return filteredElements;
    }

    public List<ElementInfo> getOnlyTwoGames() {
        List<ElementInfo> filteredElements = getFilteredElements();

        int startIndex = 0;
        int endIndex = 2;

        return filteredElements.subList(startIndex, endIndex);
    }
}
