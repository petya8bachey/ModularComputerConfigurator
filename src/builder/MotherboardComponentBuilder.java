package builder;

import component.ComponentInterface;
import decorator.FormFactorDecorator;
import decorator.SocketDecorator;
import decorator.TypeDecorator;

public class MotherboardComponentBuilder extends ComponentBuilderAbstract {
    String socket;
    String formFactor;

    public MotherboardComponentBuilder setSocket(String socket) {
        this.socket = socket;
        return this;
    }

    public MotherboardComponentBuilder setFormFactor(String formFactor) {
        this.formFactor = formFactor;
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
        component = new FormFactorDecorator(component, formFactor);
        return component;
    }
}
