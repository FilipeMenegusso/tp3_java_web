package br.edu.infnet.integration.apichallenges.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ApiUtil {
    public static HttpURLConnection abrirConexao(String enderecoUrl, String metodo) throws IOException {
        URL url = new URL(enderecoUrl);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod(metodo);
        conexao.setRequestProperty("Content-Type", "application/json");
        return conexao;
    }

    public static BufferedReader lerResposta(HttpURLConnection conexao) throws IOException {
        return new BufferedReader(
                new InputStreamReader(conexao.getInputStream(), StandardCharsets.UTF_8)
        );
    }
}
