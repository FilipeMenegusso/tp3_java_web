package br.edu.infnet.integration.apichallenges.dto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EntitiesResponse {
    public List<Entity> entities;

    public List<Entity> getEntities() {
        return entities.stream()
                .sorted(Comparator.comparing(Entity::getId))
                .collect(Collectors.toList());
    }
}

