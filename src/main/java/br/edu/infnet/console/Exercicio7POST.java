package br.edu.infnet.console;

import br.edu.infnet.integration.apichallenges.client.ApiEntitiesClient;
import br.edu.infnet.integration.apichallenges.dto.Entity;

public class Exercicio7POST {
    public static void main(String[] args) throws Exception {
        Entity entidade = new Entity(10, "Atualizado", "");
        Entity entidadeAtualizada = ApiEntitiesClient.atualizarEntidade(entidade, ApiEntitiesClient.POST);

        System.out.println(entidadeAtualizada.toString());
    }
}
