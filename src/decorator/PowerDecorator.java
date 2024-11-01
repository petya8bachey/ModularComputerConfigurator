package decorator;

import component.ComponentInterface;

public class PowerDecorator extends ComponentDecorator {
    private final int power;

    public PowerDecorator(ComponentInterface component, int power) {
        super(component);
        this.power = power;
    }

    @Override
    public String toString() {
        return "%s power='%d'".formatted(component.toString(), power);
    }
}
