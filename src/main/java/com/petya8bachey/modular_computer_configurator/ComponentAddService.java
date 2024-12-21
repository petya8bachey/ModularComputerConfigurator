package com.petya8bachey.modular_computer_configurator;

import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;

@Service
public class ComponentAddService {
    @Autowired
    private ComponentRepository componentRepository;
    private final BlockingQueue<Component> queue = new ArrayBlockingQueue<>(3);

    @SneakyThrows
    @Async
    public CompletableFuture<Void> addComponent(Component component) {
        queue.put(component);
        return CompletableFuture.completedFuture(null);
    }


    @SneakyThrows
    private void simulateDelay() {
        Random random = new Random();
        Thread.sleep(random.nextInt(100) + 100);
    }

    @PostConstruct
    private void runHandler() {
        Thread thread = new Thread(new ComponentHandler(componentRepository, queue));
        thread.start();
    }
}
class ComponentHandler implements Runnable {
    private ComponentRepository componentRepository;
    private final BlockingQueue<Component> queue;

    @SneakyThrows
    private void simulateDelay() {
        Random random = new Random();
        Thread.sleep(random.nextInt(100) + 100);
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            Component component = queue.take();
            simulateDelay();
            componentRepository.save(component);
        }
    }

    public ComponentHandler(ComponentRepository componentRepository, BlockingQueue<Component> queue) {
        this.componentRepository = componentRepository;
        this.queue = queue;
    }
}
