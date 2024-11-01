package builder;

import component.ComponentInterface;
import decorator.SocketDecorator;
import decorator.TypeDecorator;

public class ProcessorComponentBuilder extends ComponentBuilderAbstract {
    String socket;

     public ProcessorComponentBuilder setSocket(String socket) {
        this.socket = socket;
        return this;
    }

    @Override
    public ProcessorComponentBuilder setComponent(ComponentInterface component) {
        this.component = new TypeDecorator(component, "processor");
        return this;
    }

    @Override
    public ComponentInterface build() {
         component = new SocketDecorator(component, socket);
         return component;
    }
}
