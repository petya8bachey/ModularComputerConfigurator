package checker;

import component.ComponentInterface;

import java.util.List;

public class PowerChecker extends CompatibilityCheckerAbstract {

    @Override
    public String checkCompatibility(List<ComponentInterface> components) {
        int totalPowerConsumption = 0;
        int powerSupplyWattage = 0;

        for (ComponentInterface component : components) {
            String componentString = component.toString();

            if (componentString.toLowerCase().contains("power supply")) {
                powerSupplyWattage = extractPower(componentString);
            } else if (componentString.toLowerCase().contains("processor")) {
                totalPowerConsumption += 65;
            } else if (componentString.toLowerCase().contains("motherboard")) {
                totalPowerConsumption += 50;
            } else if (componentString.toLowerCase().contains("memory")) {
                totalPowerConsumption += 5;
            } else if (componentString.toLowerCase().contains("video card")) {
                totalPowerConsumption += extractPower(componentString);
            } else if (componentString.toLowerCase().contains("storage")) {
                totalPowerConsumption += 10;
            }
        }

        if (powerSupplyWattage >= totalPowerConsumption) {
            return "Power compatibility: OK";
        } else {
            return "Compatibility error: power supply wattage '%d' is not enough for total consumption '%d'"
                    .formatted(powerSupplyWattage, totalPowerConsumption);
        }
    }

    private int extractPower(String componentString) {
        int startIndex = componentString.indexOf("power='") + "power='".length();
        int endIndex = componentString.indexOf("'", startIndex);
        return Integer.parseInt(componentString.substring(startIndex, endIndex));
    }
}
