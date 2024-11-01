import builder.*;
import checker.*;
import checker.SocketChecker;
import component.Component;
import component.ComponentInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Основной класс
 * @author petya8bachey
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ProcessorComponentBuilder processorBuilder = new ProcessorComponentBuilder();
        ComponentInterface cpu = processorBuilder.setComponent(new Component("5600", "AMD"))
                .setSocket("AM4")
                .build();

        MotherboardComponentBuilder motherboardBuilder = new MotherboardComponentBuilder();
        ComponentInterface motherboard = motherboardBuilder
                .setComponent(new Component("B450", "ASUS"))
                .setSocket("AM4")
                .build();

        MemoryComponentBuilder memoryBuilder = new MemoryComponentBuilder();
        ComponentInterface ram = memoryBuilder
                .setComponent(new Component("Vengeance", "Corsair"))
                .setMemorySize(8192)
                .setFrequency(3200)
                .build();

        ComponentInterface videoCard = new VideoComponentCardBuilder()
                .setComponent(new Component("RTX 3080", "NVIDIA"))
                .setMemorySize(10240)
                .setFrequency(1750)
                .setPower(320)
                .build();

        StorageComponentBuilder storageBuilder = new StorageComponentBuilder();
        ComponentInterface storage = storageBuilder
                .setComponent(new Component("970 EVO", "Samsung"))
                .setStorageSize(1000)
                .setStorageType("SSD")
                .build();

        PowerSupplyComponentBuilder powerSupplyBuilder = new PowerSupplyComponentBuilder();
        ComponentInterface powerSupply = powerSupplyBuilder
                .setComponent(new Component("Supernova 850 G5", "EVGA"))
                .setWattage(850)
                .build();

        System.out.println(cpu);
        System.out.println(motherboard);
        System.out.println(ram);
        System.out.println(videoCard);
        System.out.println(storage);
        System.out.println(powerSupply);

        List<ComponentInterface> components = new ArrayList<>();
        components.add(cpu);
        components.add(motherboard);
        components.add(ram);
        components.add(videoCard);
        components.add(storage);
        components.add(powerSupply);
        components.add(storage);

        CompatibilityCheckerInterface powerChecker = new PowerChecker();
        CompatibilityCheckerInterface socketChecker = new SocketChecker();

        powerChecker.setNextChecker(socketChecker);

        System.out.println(powerChecker.checkCompatibility(components));
    }
}