package builder;

import component.ComponentInterface;
import decorator.SocketDecorator;
import decorator.TypeDecorator;

public class MotherboardComponentBuilder extends ComponentBuilderAbstract {

    public MotherboardComponentBuilder setSocket(String socket) {
        component = new SocketDecorator(component, socket);
        return this;
    }

    @Override
    public MotherboardComponentBuilder setComponent(ComponentInterface component) {
        this.component = new TypeDecorator(component, "motherboard");
        return this;
    }
}
