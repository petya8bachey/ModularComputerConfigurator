package com.petya8bachey.modular_computer_configurator;

import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;

@Service
public class ConfigurationService {
    @Autowired
    private ComponentRepository componentRepository;

    @Autowired
    private ComponentAddService componentAddService;

    public List<List<Component>> generateConfigurations() {
        // Группируем компоненты по типу
        List<Component> cpus = componentRepository.findByType(ComponentType.CPU);
        List<Component> gpus = componentRepository.findByType(ComponentType.GPU);
        List<Component> rams = componentRepository.findByType(ComponentType.RAM);
        List<Component> mbs = componentRepository.findByType(ComponentType.MOTHERBOARD);

        List<List<Component>> configurations = new ArrayList<>();
        for (Component cpu : cpus) {
            for (Component gpu : gpus) {
                for (Component ram : rams) {
                    for (Component mb : mbs) {
                        if (isCompatible(cpu, gpu, ram, mb)) {
                            List<Component> config = new ArrayList<>();
                            config.add(cpu);
                            config.add(gpu);
                            config.add(ram);
                            config.add(mb);
                            configurations.add(config);
                        }
                    }
                }
            }
        }
        return configurations;
    }


    private boolean isCompatible(Component cpu, Component gpu, Component ram, Component mb) {
        if (!mb.getCompatibility().containsAll(cpu.getRequirement())) {
            return false;
        }

        if (!mb.getCompatibility().containsAll(gpu.getRequirement())) {
            return false;
        }

        if (!mb.getCompatibility().containsAll(ram.getRequirement())) {
            return false;
        }

        return true;
    }

    @PostConstruct
    private void initializeComponents() {
        // Check if the repository is empty before adding default components
        if (componentRepository.count() == 0) {
            System.out.println("Инициализация базы данных с компонентами...");

            // Create some sample components
            Component cpu1 = new Component();
            cpu1.setType(ComponentType.CPU);
            cpu1.setName("AMD Ryzen 5 5600X");
            cpu1.setManufacturer("AMD");
            cpu1.addRequirement(CompatibilityType.SOCKET_AM4);

            Component cpu2 = new Component();
            cpu2.setType(ComponentType.CPU);
            cpu2.setName("Intel Core i7-10700K");
            cpu2.setManufacturer("Intel");
            cpu2.addRequirement(CompatibilityType.SOCKET_LGA1200);

            Component gpu1 = new Component();
            gpu1.setType(ComponentType.GPU);
            gpu1.setName("NVIDIA RTX 3070");
            gpu1.setManufacturer("NVIDIA");
            gpu1.addRequirement(CompatibilityType.PCIe_3_0);

            Component gpu2 = new Component();
            gpu2.setType(ComponentType.GPU);
            gpu2.setName("AMD Radeon RX 6700 XT");
            gpu2.setManufacturer("AMD");
            gpu2.addRequirement(CompatibilityType.PCIe_4_0);

            Component ram1 = new Component();
            ram1.setType(ComponentType.RAM);
            ram1.setName("Corsair Vengeance LPX 16GB");
            ram1.setManufacturer("Corsair");
            ram1.addRequirement(CompatibilityType.DDR4);

            Component ram2 = new Component();
            ram2.setType(ComponentType.RAM);
            ram2.setName("G.SKILL Ripjaws V 16GB");
            ram2.setManufacturer("G.SKILL");
            ram2.addRequirement(CompatibilityType.DDR5);

            Component mb1 = new Component();
            mb1.setType(ComponentType.MOTHERBOARD);
            mb1.setName("ASUS ROG Strix B550-F");
            mb1.setManufacturer("ASUS");
            mb1.addCompatibility(CompatibilityType.SOCKET_AM4);
            mb1.addCompatibility(CompatibilityType.PCIe_3_0);
            mb1.addCompatibility(CompatibilityType.DDR4);

            Component mb2 = new Component();
            mb2.setType(ComponentType.MOTHERBOARD);
            mb2.setName("MSI MPG Z490 GAMING EDGE WIFI");
            mb2.setManufacturer("MSI");
            mb2.addCompatibility(CompatibilityType.SOCKET_LGA1200);
            mb2.addCompatibility(CompatibilityType.PCIe_3_0);
            mb2.addCompatibility(CompatibilityType.DDR4);

            Component mb3 = new Component();
            mb3.setType(ComponentType.MOTHERBOARD);
            mb3.setName("Gigabyte Z690 AORUS MASTER");
            mb3.setManufacturer("Gigabyte");
            mb3.addCompatibility(CompatibilityType.SOCKET_LGA1200);
            mb3.addCompatibility(CompatibilityType.PCIe_4_0);
            mb3.addCompatibility(CompatibilityType.DDR5);

            for (Component component : List.of(cpu1, cpu2, gpu1, gpu2, ram1, ram2, mb1, mb2, mb3)) {
                addComponentsToQueue(component);
            }

            System.out.println("Компоненты добавлены в базу данных.");
        }
    }

    public void addComponentsToQueue(Component component) {
        simulateDelay();
        CompletableFuture<Void> future = componentAddService.addComponent(component);
        future.join();
    }


    @SneakyThrows
    public void simulateDelay() {
        Random random = new Random();
        Thread.sleep(random.nextInt(100) + 100);
    }

    public int countComponents() {
        return (int) componentRepository.count();
    }
}
