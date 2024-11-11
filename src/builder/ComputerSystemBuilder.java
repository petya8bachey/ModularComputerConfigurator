package builder;

import component.ComponentInterface;
import component.ComputerSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Управляет процессом сборки системы из компонентов
 * @author petya8bachey
 * @version 1.0
 */
public class ComputerSystemBuilder implements Iterable<ComputerSystemComponent>{
    ComputerSystemComponent body = new ComputerSystemComponent();
    ComputerSystemComponent motherboard = new ComputerSystemComponent();

    public ComputerSystemBuilder() {}

    public ComputerSystemBuilder setBody(ComponentInterface body) {
        this.body.setComponent(body);
        return this;
    }

    public ComputerSystemBuilder setMotherboard(ComponentInterface motherboard) {
        this.motherboard.setComponent(motherboard);
        return this;
    }

    public ComputerSystemBuilder addComponentToBody(ComponentInterface component) {
        body.addComponent(component);
        return this;
    }

    public ComputerSystemBuilder addComponentToMotherboard(ComponentInterface component) {
        motherboard.addComponent(component);
        return this;
    }

    public ComputerSystem build() {
        return new ComputerSystem(this);
    }

    public List<ComponentInterface> getComponents() {
        List<ComponentInterface> components = new ArrayList<>();
        components.add(body.getThisComponent());
        if (body.getComponents() != null) {
            for (ComputerSystemComponent component : body.getComponents()) {
                components.add(component.getThisComponent());
            }
        }
        components.add(motherboard.getThisComponent());
        if (motherboard.getComponents() != null) {
            for (ComputerSystemComponent component : motherboard.getComponents()) {
                components.add(component.getThisComponent());
            }
        }
        return components;
    }

    private List<ComputerSystemComponent> getTree() {
        List<ComputerSystemComponent> components = new ArrayList<>();
        components.add(body);
        components.addAll(body.getComponents());
        components.add(motherboard);
        components.addAll(motherboard.getComponents());
        return components;
    }

    @Override
    public Iterator<ComputerSystemComponent> iterator() {
        return new Iterator<>() {
            final List<ComputerSystemComponent> elements = getTree();
            final Iterator<ComputerSystemComponent> iterator = elements.iterator();
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }
            @Override
            public ComputerSystemComponent next() {
                return iterator.next();
            }
        };
    }
}