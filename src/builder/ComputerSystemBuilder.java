package builder;

import component.ComponentInterface;
import component.ComputerSystem;

/**
 * Управляет процессом сборки системы из компонентов
 * @author petya8bachey
 * @version 1.0
 */
public class ComputerSystemBuilder {
    ComputerSystemComponent body;
    ComputerSystemComponent motherboard;

    public ComputerSystemBuilder() {}

    public ComputerSystemBuilder setBody(ComponentInterface body) {
        this.body = new ComputerSystemComponent(body);
        return this;
    }

    public ComputerSystemBuilder setMotherboard(ComponentInterface motherboard) {
        this.motherboard = new ComputerSystemComponent(motherboard);
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
}