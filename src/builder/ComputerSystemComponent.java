package builder;

import component.ComponentInterface;

import java.util.ArrayList;
import java.util.Iterator;
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
        ComputerSystemComponent systemComponent = new ComputerSystemComponent();
        systemComponent.setComponent(component);
        components.add(systemComponent);
    }
    public void setComponent(ComponentInterface component) {
        thisComponent = component;
    }
    public ComputerSystemComponent() {}

    public ComponentInterface getThisComponent() {
        return thisComponent;
    }
}
