package io.github.fernandoferreira.observer.util;

import io.github.fernandoferreira.observer.domain.dto.ClientRequest;
import io.github.fernandoferreira.observer.domain.dto.ClientResponse;

public class ClientTestUtil {

    private ClientTestUtil() {
    }

    public static ClientRequest getClientRequestInstance() {
        ClientRequest client = new ClientRequest();
        client.setName("John Walker");
        client.setAge(12);
        client.setDocument("111.222.333-44");

        return client;
    }

    public static ClientResponse getClientResponseInstance() {
        ClientResponse client = new ClientResponse();
        client.setId(1);
        client.setName("John Walker");
        client.setWelcomeMessage("Welcome Message");

        return client;
    }
}
