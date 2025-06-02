package br.edu.infnet.console;

import br.edu.infnet.integration.apichallenges.client.ApiEntitiesClient;
import br.edu.infnet.integration.apichallenges.dto.Entity;

public class Exercicio5Post {
    public static void main(String[] args) throws Exception {
        Entity entidade = ApiEntitiesClient.salvarEntidade("Filipe");

        System.out.println(entidade.toString());
    }
}
