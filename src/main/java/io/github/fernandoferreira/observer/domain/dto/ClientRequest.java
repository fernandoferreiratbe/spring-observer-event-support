package io.github.fernandoferreira.observer.domain.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ClientRequest {

    private String name;
    private Integer age;
    private String document;

}
