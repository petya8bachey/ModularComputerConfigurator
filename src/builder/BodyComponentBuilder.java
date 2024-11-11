package builder;

import component.ComponentInterface;
import decorator.FormFactorDecorator;
import decorator.SizeDecorator;
import decorator.StorageTypeDecorator;
import decorator.TypeDecorator;

public class BodyComponentBuilder extends ComponentBuilderAbstract {
    String formFactor;
    @Override
    public BodyComponentBuilder setComponent(ComponentInterface component) {
        this.component = new TypeDecorator(component, "body");
        return this;
    }

    public BodyComponentBuilder setFormFactor(String formFactor) {
        this.formFactor = formFactor;
        return this;
    }

    @Override
    public ComponentInterface build() {
        component = new FormFactorDecorator(component, formFactor);
        return component;
    }
}
