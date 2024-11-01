package builder;

import component.ComponentInterface;
import decorator.SocketDecorator;
import decorator.TypeDecorator;

public class MotherboardComponentBuilder extends ComponentBuilderAbstract {
    String socket;

    public MotherboardComponentBuilder setSocket(String socket) {
        this.socket = socket;
        return this;
    }

    @Override
    public MotherboardComponentBuilder setComponent(ComponentInterface component) {
        this.component = new TypeDecorator(component, "motherboard");
        return this;
    }

    @Override
    public ComponentInterface build() {
        component = new SocketDecorator(component, socket);
        return component;
    }
}
