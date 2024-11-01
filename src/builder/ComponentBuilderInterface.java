package builder;

import component.ComponentInterface;

public interface ComponentBuilderInterface {
    ComponentInterface build();
    ComponentBuilderInterface setComponent(ComponentInterface component);
}
