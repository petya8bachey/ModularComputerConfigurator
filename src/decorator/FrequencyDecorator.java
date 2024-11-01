package decorator;

import component.ComponentInterface;

public class FrequencyDecorator extends ComponentDecorator {
    private final int frequency;

    public FrequencyDecorator(ComponentInterface component, int frequency) {
        super(component);
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "%s frequency='%d'".formatted(component.toString(), frequency);
    }
}
