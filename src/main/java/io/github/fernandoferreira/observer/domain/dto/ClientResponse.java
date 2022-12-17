package io.github.fernandoferreira.observer.domain.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ClientResponse {
    private Integer id;
    private String name;
    private String welcomeMessage;
}
