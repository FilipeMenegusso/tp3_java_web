package br.edu.infnet.console;

import br.edu.infnet.integration.apichallenges.client.ApiEntitiesClient;
import br.edu.infnet.integration.apichallenges.dto.Entity;

public class Exercicio8PUT {
    public static void main(String[] args) throws Exception {
        Entity entidade = new Entity(10, "Atualizado", "");
        Entity entidadeAtualizada = ApiEntitiesClient.atualizarEntidade(entidade, ApiEntitiesClient.PUT);

        System.out.println(entidadeAtualizada.toString());
    }
}
