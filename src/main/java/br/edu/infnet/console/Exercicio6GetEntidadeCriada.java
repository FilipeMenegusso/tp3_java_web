package br.edu.infnet.console;

import br.edu.infnet.integration.apichallenges.client.ApiEntitiesClient;
import br.edu.infnet.integration.apichallenges.dto.Entity;
import com.sun.security.jgss.GSSUtil;

public class Exercicio6GetEntidadeCriada {
    public static void main(String[] args) throws Exception {
        Entity entidadeCriada = ApiEntitiesClient.salvarEntidade("Filipe");
        Entity entidadeRecuperada = ApiEntitiesClient.obterEntidade(entidadeCriada.getId());

        System.out.println(entidadeRecuperada.toString());
    }
}
