package br.edu.infnet.integration.apichallenges.client;
import br.edu.infnet.integration.apichallenges.dto.Entity;
import br.edu.infnet.integration.apichallenges.dto.EntityResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ApiEntitiesClient {
    private static final String URL_BASE = "https://apichallenges.eviltester.com/sim/entities";

    public static final String POST = "POST";
    public static final String PUT = "PUT";
    private static final String GET = "GET";
    private static final String DELETE = "DELETE";
    private static final String OPTIONS = "OPTIONS";

    public static List<Entity> obterTodasAsEntidades() throws Exception {
        HttpURLConnection conexao = abrirConexao(URL_BASE, GET);
        BufferedReader leitor = lerResposta(conexao);

        String jsonEntidades = leitor.readLine();

        leitor.close();

        ObjectMapper mapper = new ObjectMapper();
        EntityResponse response = mapper.readValue(jsonEntidades, EntityResponse.class);

        return response.getEntities();
    }

    public static Entity obterEntidade(int id) throws Exception {
        String url = String.format("%s/%d", URL_BASE, id);
        HttpURLConnection conexao = abrirConexao(url, GET);

        try {
            BufferedReader leitor = lerResposta(conexao);

            String jsonEntidade = leitor.readLine();

            leitor.close();

            Entity entidade = mapearParaEntidade(jsonEntidade);

            return entidade;
        } catch (FileNotFoundException e) {
            return null;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Entity> obterEntidadesPorCategoriaELimite(String categoria, int limite) throws Exception {
        String url = String.format("%s?categoria=%s&limite=%d", URL_BASE, categoria, limite);
        HttpURLConnection conexao = abrirConexao(url, GET);

        try {
            BufferedReader leitor = lerResposta(conexao);

            String jsonEntidades = leitor.readLine();

            leitor.close();

            ObjectMapper mapper = new ObjectMapper();
            EntityResponse response = mapper.readValue(jsonEntidades, EntityResponse.class);

            return response.getEntities();
        } catch (FileNotFoundException e) {
            return null;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Entity salvarEntidade(String nome) throws Exception {
        HttpURLConnection conexao = (abrirConexao(URL_BASE, POST));
        conexao.setConnectTimeout(10_000);
        conexao.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(conexao.getOutputStream());
        out.writeBytes(String.format("{\"name\":\"%s\"}", nome));
        out.flush();
        out.close();

        BufferedReader leitor = lerResposta(conexao);

        String jsonEntidade = leitor.readLine();

        return mapearParaEntidade(jsonEntidade);
    }

    public static Entity atualizarEntidade(Entity entidade, String metodo) throws Exception {
        String url = String.format("%s/%d", URL_BASE, entidade.getId());
        HttpURLConnection conexao = (abrirConexao(url, metodo));
        conexao.setConnectTimeout(10_000);
        conexao.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(conexao.getOutputStream());
        out.writeBytes(String.format("{\"name\":\"%s\"}", entidade.getName()));
        out.flush();
        out.close();

        BufferedReader leitor = lerResposta(conexao);
        String jsonEntidade = leitor.readLine();

        return mapearParaEntidade(jsonEntidade);
    }

    public static void deletarEntidade(int id) throws Exception {
        String url = String.format("%s/%d", URL_BASE, id);
        HttpURLConnection conexao = abrirConexao(url, DELETE);
    }
    public static String obterOptions() throws Exception {
        HttpURLConnection conexao = abrirConexao(URL_BASE, OPTIONS);

        int responseCode = conexao.getResponseCode();

        if (responseCode != HttpURLConnection.HTTP_OK && responseCode != HttpURLConnection.HTTP_NO_CONTENT)
            throw new IOException("Erro na requisção OPTIONS: Código " + responseCode);

        String metodosPermitidos = conexao.getHeaderField("Allow");
        if (metodosPermitidos != null)
            return metodosPermitidos;
        else
            return "Cabeçalho 'Allow' não encontrado.";
    }

    private static Entity mapearParaEntidade(String jsonEntidade) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonEntidade, Entity.class);
    }

    private static BufferedReader lerResposta(HttpURLConnection conexao) throws IOException {
        return new BufferedReader(
            new InputStreamReader(conexao.getInputStream(), StandardCharsets.UTF_8)
        );
    }

    private static HttpURLConnection abrirConexao(String enderecoUrl, String metodo) throws IOException {
        URL url = new URL(enderecoUrl);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod(metodo);
        conexao.setRequestProperty("Content-Type", "application/json");
        return conexao;
    }
}
