import builder.*;
import component.Component;
import component.ComponentInterface;
import component.ComputerSystem;

/**
 * Основной класс
 * @author petya8bachey
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ComputerSystemBuilder builder = new ComputerSystemBuilder();

        ComponentInterface body = new BodyComponentBuilder()
                .setComponent(new Component("DC-202M", "DEXP"))
                .setFormFactor("ATX")
                .build();

        ComponentInterface cpu = new ProcessorComponentBuilder()
                .setComponent(new Component("5600", "AMD"))
                .setSocket("AM4")
                .build();

        ComponentInterface motherboard = BuilderFactory.getMotherboardComponentBuilder()
                .setComponent(new Component("B450", "ASUS"))
                .setSocket("AM4")
                .setFormFactor("ATX")
                .build();

        ComponentInterface ram = BuilderFactory.getMemoryComponentBuilder()
                .setComponent(new Component("Vengeance", "Corsair"))
                .setMemorySize(8192)
                .setFrequency(3200)
                .build();

        ComponentInterface videoCard = BuilderFactory.getVideoCardComponentBuilder()
                .setComponent(new Component("RTX 3080", "NVIDIA"))
                .setMemorySize(10240)
                .setFrequency(1750)
                .setPower(320)
                .build();

        ComponentInterface storage = BuilderFactory.getStorageComponentBuilder()
                .setComponent(new Component("970 EVO", "Samsung"))
                .setStorageSize(1000)
                .setStorageType("SSD")
                .build();

        ComponentInterface powerSupply = BuilderFactory.getPowerSupplyComponentBuilder()
                .setComponent(new Component("Supernova 850 G5", "EVGA"))
                .setWattage(850)
                .build();

        builder.setBody(body)
                .setMotherboard(motherboard)
                .addComponentToMotherboard(cpu)
                .addComponentToMotherboard(ram)
                .addComponentToMotherboard(videoCard)
                .addComponentToMotherboard(storage)
                .addComponentToMotherboard(powerSupply);

        ComputerSystem computerSystem = builder.build();

        for (ComponentInterface component : computerSystem.getComponents()) {
            System.out.println(component);
        }

        System.out.println(computerSystem.check());
    }
}