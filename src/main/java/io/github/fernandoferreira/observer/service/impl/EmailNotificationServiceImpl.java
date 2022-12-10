package io.github.fernandoferreira.observer.service.impl;

import io.github.fernandoferreira.observer.domain.ClientEvent;
import io.github.fernandoferreira.observer.service.NotificationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationServiceImpl implements NotificationService {

    @Override
    @EventListener
    public void notify(ClientEvent clientEvent) {
        System.out.println("E-mail Notification sent to client -> " + clientEvent.getClient().getName());
    }
}
