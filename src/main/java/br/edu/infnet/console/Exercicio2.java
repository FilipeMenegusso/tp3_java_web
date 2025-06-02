package br.edu.infnet.console;

import br.edu.infnet.integration.apichallenges.dto.Entity;
import br.edu.infnet.integration.apichallenges.client.ApiEntitiesClient;

public class Exercicio2 {
    public static void main(String[] args) throws Exception {
        Entity entidade = ApiEntitiesClient.obterEntidade(1);
        System.out.println(entidade.toString());
    }
}
