package io.github.fernandoferreira.observer.domain.dto;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResponse {
    private Integer id;
    private String name;
    private String welcomeMessage;
}
