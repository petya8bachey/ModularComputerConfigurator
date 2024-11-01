package builder;

import component.ComponentInterface;

import java.util.ArrayList;
import java.util.List;

public class ComputerSystemComponent {
    ComponentInterface thisComponent = null;
    List<ComputerSystemComponent> components  = null;

    public List<ComputerSystemComponent> getComponents() {
        return components;
    }

    public void addComponent(ComponentInterface component) {
        if (components == null) {
            components = new ArrayList<>();
        }
        components.add(new ComputerSystemComponent(component));
    }

    public ComputerSystemComponent(ComponentInterface component) {
        thisComponent = component;
    }
}
