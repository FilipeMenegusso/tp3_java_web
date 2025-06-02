package br.edu.infnet.console;

import br.edu.infnet.integration.apichallenges.client.ApiEntitiesClient;

import java.io.FileNotFoundException;

public class Exercicio10DELETE_INVALIDO {
    public static void main(String[] args) throws Exception {
        final int idEntidade = 2;
        try
        {
            ApiEntitiesClient.deletarEntidade(idEntidade);
            System.out.println("Entidade deletada com sucesso!");
        } catch (Exception e) {
            System.out.println(String.format("Não existe entidade com o ID: %d", idEntidade));
        }
    }
}
