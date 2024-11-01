package decorator;

import component.ComponentInterface;

public class TypeDecorator extends ComponentDecorator {
    String type;

    public TypeDecorator(ComponentInterface component, String type) {
        super(component);
        this.type = type;
    }

    @Override
    public String toString() {
        return "%s component type='%s'".formatted(component.toString(), type);
    }
}
