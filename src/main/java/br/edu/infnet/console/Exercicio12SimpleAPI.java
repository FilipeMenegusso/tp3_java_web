package br.edu.infnet.console;

import br.edu.infnet.integration.apichallenges.client.ApiSimpleClient;
import br.edu.infnet.integration.apichallenges.dto.Item;

import java.util.List;
import java.util.Random;

public class Exercicio12SimpleAPI {
    public static void main(String[] args) throws Exception {
        exibirTodosItens();
        exibirIsbn();

        Item item = criarItem();
        System.out.println(item.toString());

        item.setPrice(12.99);

        ApiSimpleClient.atualizarItem(item);

        ApiSimpleClient.excluirItem(item.getId());
    }

    public static void exibirTodosItens() throws Exception {
        List<Item> items = ApiSimpleClient.obterTodosItens();
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    public static void exibirIsbn() throws Exception {
        String isbn = ApiSimpleClient.obterISBN();
        System.out.println(String.format("ISBN: %s", isbn));
    }

    public static Item criarItem() throws Exception {
        String isbn = ApiSimpleClient.obterISBN();
        Item newItem = new Item("book", isbn, 10.99, 10);
        return ApiSimpleClient.criarItem(newItem);
    }
}
