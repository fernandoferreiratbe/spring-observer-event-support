package io.github.fernandoferreira.observer.repository;

import io.github.fernandoferreira.observer.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
