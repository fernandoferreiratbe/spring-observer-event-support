package io.github.fernandoferreira.observer.controller;

import io.github.fernandoferreira.observer.domain.dto.ClientRequest;
import io.github.fernandoferreira.observer.domain.dto.ClientResponse;
import io.github.fernandoferreira.observer.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/notification")
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping
    public ResponseEntity<ClientResponse> postNotificationToClient(@RequestBody ClientRequest clientRequest) {
        ClientResponse clientResponse = this.clientService.save(clientRequest);
        return new ResponseEntity<>(clientResponse, HttpStatus.CREATED);
    }
}
