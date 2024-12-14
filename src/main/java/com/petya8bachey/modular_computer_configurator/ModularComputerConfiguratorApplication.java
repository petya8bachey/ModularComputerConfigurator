package com.petya8bachey.modular_computer_configurator;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class ModularComputerConfiguratorApplication implements CommandLineRunner {

    @Autowired
    private ConfigurationService configurationService;
    @Autowired
    private ComponentAdder componentAdder;

    public static void main(String[] args) {
        SpringApplication.run(ModularComputerConfiguratorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("=== Генерация конфигураций вычислительных систем ===");

        List<List<Component>> configurations = configurationService.generateConfigurations();

        if (configurations.isEmpty()) {
            System.out.println("Нет доступных конфигураций.");
        } else {
            int count = 1;
            for (List<Component> config : configurations) {
                System.out.println("Конфигурация " + count++ + ":");
                for (Component component : config) {
                    System.out.println("- " + component.getType() + ": " + component.getName() + " (" + component.getManufacturer() + ")");
                }
                System.out.println();
            }
        }
        simulate();
        System.out.println(configurationService.countComponents());
    }

    @SneakyThrows
    public void simulate() {
        List<CompletableFuture<Void>> componentAdders = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            componentAdders.add(componentAdder.addComponent());
            Thread.sleep(50);
        }
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(
                componentAdders.toArray(new CompletableFuture[0])
        );
        allTasks.join();

        System.out.println("Все задачи завершены!");
    }
}
