package br.edu.infnet.console;

import br.edu.infnet.integration.apichallenges.client.ApiEntitiesClient;
import br.edu.infnet.integration.apichallenges.dto.Entity;

public class Exercicio3 {
    public static void main(String[] args) throws Exception {
        int idInexistente = 13;
        Entity entidade = ApiEntitiesClient.obterEntidade(idInexistente);

        if (entidade != null)
            System.out.println(entidade.toString());
        else
            System.out.println(String.format("Não existe entidade com o ID: %d", idInexistente));
    }
}
