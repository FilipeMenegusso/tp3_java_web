package br.edu.infnet.integration.apichallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ApiEntitiesClient {
    private static final String BASE_URL = "https://apichallenges.eviltester.com/sim/entities";

    public static void exercicio1ObterTodasAsEntidades() throws Exception {
        URL url = new URL(BASE_URL);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader leitor = criarLeitorResposta(conexao);

        String line = leitor.readLine();
        leitor.close();
    }

    private static BufferedReader criarLeitorResposta(HttpURLConnection conexao) throws IOException {
        return new BufferedReader(
            new InputStreamReader(conexao.getInputStream(), StandardCharsets.UTF_8)
        );
    }
}
