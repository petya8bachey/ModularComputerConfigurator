package builder;

import component.ComponentInterface;
import decorator.PowerDecorator;
import decorator.TypeDecorator;

public class PowerSupplyComponentBuilder extends ComponentBuilderAbstract {
    private int wattage;

    public PowerSupplyComponentBuilder setWattage(int wattage) {
        this.wattage = wattage;
        return this;
    }

    @Override
    public PowerSupplyComponentBuilder setComponent(ComponentInterface component) {
        this.component = new TypeDecorator(component, "power supply");
        return this;
    }

    @Override
    public ComponentInterface build() {
        component = new PowerDecorator(component, wattage);
        return component;
    }
}
