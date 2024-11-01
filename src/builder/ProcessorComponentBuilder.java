package builder;

import component.ComponentInterface;
import decorator.SocketDecorator;
import decorator.TypeDecorator;

public class ProcessorComponentBuilder extends ComponentBuilderAbstract {
     public ComponentBuilderInterface setSocket(String socket) {
        component = new SocketDecorator(component, socket);
        return this;
    }

    @Override
    public ProcessorComponentBuilder setComponent(ComponentInterface component) {
        this.component = new TypeDecorator(component, "processor");
        return this;
    }
}
