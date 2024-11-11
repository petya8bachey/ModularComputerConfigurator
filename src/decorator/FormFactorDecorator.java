package decorator;

import component.ComponentInterface;

public class FormFactorDecorator extends ComponentDecorator {
    String formFactor;
    public FormFactorDecorator(ComponentInterface component, String formFactor) {
        super(component);
        this.formFactor = formFactor;
    }

    @Override
    public String toString() {
        return "%s formFactor='%s'".formatted(component.toString(), formFactor);
    }
}
