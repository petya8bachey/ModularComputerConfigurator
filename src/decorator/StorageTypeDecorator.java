package decorator;

import component.ComponentInterface;

public class StorageTypeDecorator extends ComponentDecorator {
    private final String storageType; // e.g., SSD, HDD

    public StorageTypeDecorator(ComponentInterface component, String storageType) {
        super(component);
        this.storageType = storageType;
    }

    @Override
    public String toString() {
        return "%s storage type='%s'".formatted(component.toString(), storageType);
    }
}

