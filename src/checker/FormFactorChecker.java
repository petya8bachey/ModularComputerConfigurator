package checker;

import component.ComponentInterface;
import java.util.List;

public class FormFactorChecker extends CompatibilityCheckerAbstract {

    @Override
    protected String performCheck(List<ComponentInterface> components) {
        String bodyFormFactor = null;
        String motherboardFormFactor = null;

        for (ComponentInterface component : components) {
            String componentString = component.toString();

            if (componentString.toLowerCase().contains("body") && componentString.contains("formFactor='")) {
                bodyFormFactor = extractFormFactor(componentString);
            } else if (componentString.toLowerCase().contains("motherboard") && componentString.contains("formFactor='")) {
                motherboardFormFactor = extractFormFactor(componentString);
            }
        }

        if (bodyFormFactor != null && motherboardFormFactor != null) {
            if (bodyFormFactor.equals(motherboardFormFactor)) {
                return "Form factor compatibility: OK";
            } else {
                return "Compatibility error: motherboard form factor '%s' does not match body form factor '%s'"
                        .formatted(motherboardFormFactor, bodyFormFactor);
            }
        } else {
            return "Error: unable to determine form factor for body and/or motherboard";
        }
    }

    private String extractFormFactor(String componentString) {
        int startIndex = componentString.indexOf("formFactor='") + "formFactor='".length();
        int endIndex = componentString.indexOf("'", startIndex);
        return componentString.substring(startIndex, endIndex);
    }
}
