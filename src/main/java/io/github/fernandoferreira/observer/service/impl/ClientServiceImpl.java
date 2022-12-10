package io.github.fernandoferreira.observer.service.impl;

import io.github.fernandoferreira.observer.domain.ClientEvent;
import io.github.fernandoferreira.observer.domain.dto.ClientRequest;
import io.github.fernandoferreira.observer.domain.dto.ClientResponse;
import io.github.fernandoferreira.observer.domain.entity.Client;
import io.github.fernandoferreira.observer.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl {

    private final ModelMapper modelMapper;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public ClientServiceImpl() {
        this.modelMapper = new ModelMapper();
    }

    public ClientResponse save(ClientRequest clientRequest) {
        Client client = this.modelMapper.map(clientRequest, Client.class);

        this.clientRepository.save(client);
        this.applicationEventPublisher.publishEvent(new ClientEvent(client));

        ClientResponse clientResponse = this.modelMapper.map(client, ClientResponse.class);
        clientResponse.setWelcomeMessage("Welcome " + clientResponse.getName() + ". We are glad you came. Your id is: " + clientResponse.getId());

        return clientResponse;
    }
}
