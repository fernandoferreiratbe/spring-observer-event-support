package io.github.fernandoferreira.observer.service;

import io.github.fernandoferreira.observer.domain.ClientEvent;
import io.github.fernandoferreira.observer.domain.entity.Client;

public interface NotificationService {

    void notify(ClientEvent client);

}
