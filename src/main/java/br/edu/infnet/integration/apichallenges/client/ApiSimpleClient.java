package br.edu.infnet.integration.apichallenges.client;

import br.edu.infnet.integration.apichallenges.dto.Item;
import br.edu.infnet.integration.apichallenges.dto.ItemsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

public class ApiSimpleClient {
    private final static String URL_BASE_ITEMS = "https://apichallenges.eviltester.com/simpleapi/items";
    private final static String URL_RANDOM_ISBN = "https://apichallenges.eviltester.com/simpleapi/randomisbn";

    private final static String POST = "POST";
    private final static String GET = "GET";
    private final static String PUT = "PUT";
    private final static String DELETE = "DELETE";

    public static List<Item> obterTodosItens() throws IOException {
        HttpURLConnection conexao = ApiUtil.abrirConexao(URL_BASE_ITEMS, GET);
        BufferedReader leitor = ApiUtil.lerResposta(conexao);

        String jsonItems = leitor.readLine();

        leitor.close();

        ObjectMapper mapper = new ObjectMapper();
        ItemsResponse response = mapper.readValue(jsonItems, ItemsResponse.class);

        return response.getItems();
    }

    public static String obterISBN() throws IOException {
        HttpURLConnection conexao = ApiUtil.abrirConexao(URL_RANDOM_ISBN, GET);
        BufferedReader leitor = ApiUtil.lerResposta(conexao);

        String isbn = leitor.readLine();

        leitor.close();

        return isbn;
    }

    public static Item criarItem(Item item) throws IOException {
        HttpURLConnection conexao = ApiUtil.abrirConexao(URL_BASE_ITEMS, POST);
        conexao.setConnectTimeout(10_000);
        conexao.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(conexao.getOutputStream());
        out.writeBytes(item.ToJson());
        out.flush();
        out.close();

        BufferedReader leitor = ApiUtil.lerResposta(conexao);
        String jsonResponse = leitor.readLine();
        leitor.close();

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonResponse, Item.class);
    }

    public static void atualizarItem(Item item) throws IOException {
        HttpURLConnection conexao = ApiUtil.abrirConexao(URL_BASE_ITEMS + "/" + item.getId(), PUT);
        conexao.setConnectTimeout(10_000);
        conexao.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(conexao.getOutputStream());
        out.writeBytes(item.ToJson());
        out.flush();
        out.close();

        BufferedReader leitor = ApiUtil.lerResposta(conexao);
        String jsonResponse = leitor.readLine();
        leitor.close();

        ObjectMapper mapper = new ObjectMapper();
        mapper.readValue(jsonResponse, Item.class);
    }

    public static void excluirItem(int itemId) throws IOException {
        HttpURLConnection conexao = ApiUtil.abrirConexao(URL_BASE_ITEMS + "/" + itemId, DELETE);
        conexao.setConnectTimeout(10_000);
        conexao.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(conexao.getOutputStream());
        out.flush();
        out.close();

        BufferedReader leitor = ApiUtil.lerResposta(conexao);
        String jsonResponse = leitor.readLine();
        leitor.close();
    }
}
