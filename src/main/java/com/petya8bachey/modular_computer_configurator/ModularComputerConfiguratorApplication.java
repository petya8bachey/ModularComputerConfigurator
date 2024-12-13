package com.petya8bachey.modular_computer_configurator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ModularComputerConfiguratorApplication implements CommandLineRunner {

    @Autowired
    private ConfigurationService configurationService;

    @Autowired
    private ComponentRepository componentRepository;

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
    }
}
