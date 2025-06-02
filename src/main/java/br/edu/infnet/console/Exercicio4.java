package br.edu.infnet.console;

import br.edu.infnet.integration.apichallenges.client.ApiEntitiesClient;
import br.edu.infnet.integration.apichallenges.dto.Entity;

import java.util.List;

public class Exercicio4 {
    public static void main(String[] args) throws Exception {
        final String categoria = "teste";
        final int limite = 5;

        List<Entity> entidades = ApiEntitiesClient.obterEntidadesPorCategoriaELimite(categoria, limite);

        for (Entity entidade : entidades)
            System.out.println(entidade.toString());
    }
}
