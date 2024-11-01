package builder;

import component.ComponentInterface;

public abstract class ComponentBuilderAbstract implements ComponentBuilderInterface {
    ComponentInterface component;

    @Override
    public ComponentInterface build() {
        return component;
    }
}
