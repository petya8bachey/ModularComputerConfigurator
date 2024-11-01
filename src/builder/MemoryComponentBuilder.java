package builder;

import component.ComponentInterface;
import decorator.SizeDecorator;
import decorator.FrequencyDecorator;
import decorator.TypeDecorator;

public class MemoryComponentBuilder extends ComponentBuilderAbstract {
    private int memorySize; // в мегабайтах (MB)
    private int frequency;  // в мегагерцах (MHz)

    public MemoryComponentBuilder setMemorySize(int memorySize) {
        this.memorySize = memorySize;
        return this;
    }

    public MemoryComponentBuilder setFrequency(int frequency) {
        this.frequency = frequency;
        return this;
    }

    @Override
    public MemoryComponentBuilder setComponent(ComponentInterface component) {
        this.component = new TypeDecorator(component, "memory");
        return this;
    }

    @Override
    public ComponentInterface build() {
        component = new SizeDecorator(component, memorySize);
        component = new FrequencyDecorator(component, frequency);
        return component;
    }
}
