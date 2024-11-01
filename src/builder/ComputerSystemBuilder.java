package builder;

import component.ComponentInterface;
import component.ComputerSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Управляет процессом сборки системы из компонентов
 * @author petya8bachey
 * @version 1.0
 */
public class ComputerSystemBuilder {
    List<ComponentInterface> components = new ArrayList<>();
    public ComputerSystemBuilder() {
    }

    public ComputerSystem build() {
        return new ComputerSystem(this);
    }

    public ComputerSystemBuilder addComponent(ComponentInterface component) {
        components.add(component);
        return this;
    }
}
