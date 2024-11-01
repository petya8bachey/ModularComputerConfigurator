package decorator;

import component.ComponentInterface;

public class SocketDecorator extends ComponentDecorator {
    String socket;

    public SocketDecorator(ComponentInterface component, String socket) {
        super(component);
        this.socket = socket;
    }

    @Override
    public String toString() {
        return "%s socket='%s'".formatted(component.toString(), socket);
    }
}
