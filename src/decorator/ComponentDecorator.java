package decorator;

import component.ComponentInterface;

public abstract class ComponentDecorator implements ComponentInterface {
    protected ComponentInterface component;

    public ComponentDecorator(ComponentInterface component) {
        this.component = component;
    }

    @Override
    public long getId() {
        return component.getId();
    }

    @Override
    public String getModel() {
        return component.getModel();
    }

    @Override
    public String getManufacturer() {
        return component.getManufacturer();
    }
}
