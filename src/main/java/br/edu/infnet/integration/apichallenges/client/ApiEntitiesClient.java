package br.edu.infnet.integration.apichallenges.client;
import br.edu.infnet.integration.apichallenges.dto.Entity;
import br.edu.infnet.integration.apichallenges.dto.EntityResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ApiEntitiesClient {
    private static final String URL_BASE = "https://apichallenges.eviltester.com/sim/entities";

    public static List<Entity> obterTodasAsEntidades() throws Exception {
        URL url = new URL(URL_BASE);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader leitor = criarLeitorResposta(conexao);

        String jsonEntidades = leitor.readLine();

        leitor.close();

        ObjectMapper mapper = new ObjectMapper();
        EntityResponse response = mapper.readValue(jsonEntidades, EntityResponse.class);

        return response.getEntities();
    }

    public static Entity obterEntidade(int id) throws Exception {
        URL url = new URL(String.format("%s/%d", URL_BASE, id));
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

        try {
            BufferedReader leitor = criarLeitorResposta(conexao);

            String jsonEntidade = leitor.readLine();

            ObjectMapper mapper = new ObjectMapper();
            Entity entidade = mapper.readValue(jsonEntidade, Entity.class);

            return entidade;
        } catch (FileNotFoundException e) {
            return null;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static BufferedReader criarLeitorResposta(HttpURLConnection conexao) throws IOException {
        return new BufferedReader(
            new InputStreamReader(conexao.getInputStream(), StandardCharsets.UTF_8)
        );
    }
}
