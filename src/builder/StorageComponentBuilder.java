package builder;

import component.ComponentInterface;
import decorator.SizeDecorator;
import decorator.StorageTypeDecorator;
import decorator.TypeDecorator;

public class StorageComponentBuilder extends ComponentBuilderAbstract {
    private int storageSize; // in GB
    private String storageType; // e.g., SSD, HDD

    public StorageComponentBuilder setStorageSize(int storageSize) {
        this.storageSize = storageSize;
        return this;
    }

    public StorageComponentBuilder setStorageType(String storageType) {
        this.storageType = storageType;
        return this;
    }

    @Override
    public StorageComponentBuilder setComponent(ComponentInterface component) {
        this.component = new TypeDecorator(component, storageType);
        return this;
    }

    @Override
    public ComponentInterface build() {
        component = new SizeDecorator(component, storageSize);
        component = new StorageTypeDecorator(component, storageType);
        return component;
    }
}
