package io.github.fernandoferreira.observer.domain;

import io.github.fernandoferreira.observer.domain.entity.Client;
import lombok.Getter;

@Getter
public class ClientEvent {

    private final Client client;
    public ClientEvent(Client client) {
        this.client = client;
    }
}
