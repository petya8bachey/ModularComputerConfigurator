import builder.MemoryComponentBuilder;
import builder.MotherboardComponentBuilder;
import builder.ProcessorComponentBuilder;
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


        System.out.println(cpu);
        System.out.println(motherboard);
        System.out.println(ram);

        List<ComponentInterface> components = new ArrayList<>();
        components.add(cpu);
        components.add(motherboard);
        System.out.println(new SocketChecker().checkCompatibility(components));
    }
}