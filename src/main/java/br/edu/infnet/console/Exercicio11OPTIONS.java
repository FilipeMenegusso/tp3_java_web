package br.edu.infnet.console;

import br.edu.infnet.integration.apichallenges.client.ApiEntitiesClient;

public class Exercicio11OPTIONS {
    public static void main(String[] args) throws Exception {
        String options = ApiEntitiesClient.obterOptions();
        System.out.println(options);
    }
}
