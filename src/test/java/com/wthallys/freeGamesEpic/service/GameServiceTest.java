package com.wthallys.freeGamesEpic.service;

import com.wthallys.freeGamesEpic.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class GameServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private GameService gameService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(gameService, "restTemplate", restTemplate);
    }

    @Test
    void getFilteredElements() {
        // Prepare the mock data
        GameData mockGameData = new GameData();
        Data mockData = new Data();
        Catalog mockCatalog = new Catalog();
        SearchStore mockSearchStore = new SearchStore();

        Element element1 = new Element("Game 1", "Description 1", "FREE");
        element1.setPrice(new Price(new TotalPrice(new FmtPrice("0"))));
        Element element2 = new Element("Game 2", "Description 2", "PAID");
        element2.setPrice(new Price(new TotalPrice(new FmtPrice("10"))));

        mockSearchStore.setElements(List.of(element1, element2));
        mockCatalog.setSearchStore(mockSearchStore);
        mockData.setCatalog(mockCatalog);
        mockGameData.setData(mockData);

        when(restTemplate.getForObject(anyString(), GameData.class)).thenReturn(mockGameData);

        // Call the method to test
        List<ElementDTO> result = gameService.getFilteredElements();

        // Validate the result
        assertEquals(1, result.size());
        assertEquals("Game 1", result.get(0).getTitle());
        assertEquals("Description 1", result.get(0).getDescription());
        assertEquals("FREE", result.get(0).getOfferType());
    }
}