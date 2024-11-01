package decorator;

import component.ComponentInterface;

public class SizeDecorator extends ComponentDecorator {
    private final int memorySize;

    public SizeDecorator(ComponentInterface component, int memorySize) {
        super(component);
        this.memorySize = memorySize;
    }

    @Override
    public String toString() {
        return "%s memorySize='%d'".formatted(component.toString(), memorySize);
    }
}
