package builder;

import component.ComponentInterface;
import decorator.SizeDecorator;
import decorator.FrequencyDecorator;
import decorator.TypeDecorator;
import decorator.PowerDecorator;

public class VideoCardComponentBuilder extends ComponentBuilderAbstract {
    private int memorySize;
    private int frequency;
    private int power;

    public VideoCardComponentBuilder setMemorySize(int memorySize) {
        this.memorySize = memorySize;
        return this;
    }

    public VideoCardComponentBuilder setFrequency(int frequency) {
        this.frequency = frequency;
        return this;
    }

    public VideoCardComponentBuilder setPower(int power) {
        this.power = power;
        return this;
    }

    @Override
    public VideoCardComponentBuilder setComponent(ComponentInterface component) {
        this.component = new TypeDecorator(component, "video card");
        return this;
    }

    @Override
    public ComponentInterface build() {
        component = new SizeDecorator(component, memorySize);
        component = new FrequencyDecorator(component, frequency);
        component = new PowerDecorator(component, power);
        return component;
    }
}
