package br.edu.infnet.integration.apichallenges.dto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ItemsResponse {
    public List<Item> items;

    public List<Item> getItems() {
        return items.stream()
                .sorted(Comparator.comparing(Item::getId))
                .collect(Collectors.toList());
    }
}

