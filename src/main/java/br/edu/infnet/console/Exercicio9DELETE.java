package br.edu.infnet.console;

import br.edu.infnet.integration.apichallenges.client.ApiEntitiesClient;
import br.edu.infnet.integration.apichallenges.dto.Entity;

import java.io.FileNotFoundException;

public class Exercicio9DELETE {
    public static void main(String[] args) throws Exception {
        final int idEntidade = 9;
        try
        {
            ApiEntitiesClient.deletarEntidade(idEntidade);
            System.out.println("Entidade deletada com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println(String.format("Não existe entidade com o ID: %d", idEntidade));
        }
    }
}
