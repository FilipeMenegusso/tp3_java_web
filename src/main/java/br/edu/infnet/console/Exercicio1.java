package br.edu.infnet.console;

import br.edu.infnet.integration.apichallenges.dto.Entity;
import br.edu.infnet.integration.apichallenges.client.ApiEntitiesClient;

import java.util.List;

public class Exercicio1 {
    public static void main(String[] args) throws Exception {
        List<Entity> entidades = ApiEntitiesClient.obterTodasAsEntidades();

        for (Entity entidade : entidades)
            System.out.println(entidade.toString());
    }
}
