package com.petya8bachey.modular_computer_configurator;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

@org.springframework.stereotype.Component
public class ComponentAdder {

    @Autowired
    private ConfigurationService configurationService;

    @SneakyThrows
    @Async
    public CompletableFuture<Void> addComponent() {
        // Create some sample components
        Component cpu1 = new Component();
        cpu1.setType(ComponentType.CPU);
        cpu1.setName("AMD Ryzen 5 5600X");
        cpu1.setManufacturer("AMD");
        cpu1.addRequirement(CompatibilityType.SOCKET_AM4);
        configurationService.addComponent(cpu1).get();
        return CompletableFuture.completedFuture(null);
    }
}
