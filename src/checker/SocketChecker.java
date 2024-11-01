package checker;

import component.ComponentInterface;

import java.util.List;

public class SocketChecker extends CompatibilityCheckerAbstract {

    @Override
    protected String performCheck(List<ComponentInterface> components) {
        String motherboardSocket = null;
        String processorSocket = null;

        for (ComponentInterface component : components) {
            String componentString = component.toString();

            if (componentString.toLowerCase().contains("motherboard") && componentString.contains("socket='")) {
                motherboardSocket = extractSocket(componentString);
            } else if (componentString.toLowerCase().contains("processor") && componentString.contains("socket='")) {
                processorSocket = extractSocket(componentString);
            }
        }

        if (motherboardSocket != null && processorSocket != null) {
            if (motherboardSocket.equals(processorSocket)) {
                return "Socket compatibility: OK";
            } else {
                return "Compatibility error: processor socket '%s' does not match motherboard socket '%s'"
                        .formatted(processorSocket, motherboardSocket);
            }
        } else {
            return "Error: unable to determine processor and/or motherboard socket";
        }
    }


    private String extractSocket(String componentString) {
        int startIndex = componentString.indexOf("socket='") + "socket='".length();
        int endIndex = componentString.indexOf("'", startIndex);
        return componentString.substring(startIndex, endIndex);
    }
}
