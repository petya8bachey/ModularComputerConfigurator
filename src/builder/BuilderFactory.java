package builder;

public class BuilderFactory {
    private static final MotherboardComponentBuilder motherboardComponentBuilder = new MotherboardComponentBuilder();
    private static final ProcessorComponentBuilder processorComponentBuilder = new ProcessorComponentBuilder();
    private static final MemoryComponentBuilder memoryComponentBuilder = new MemoryComponentBuilder();
    private static final PowerSupplyComponentBuilder powerSupplyComponentBuilder = new PowerSupplyComponentBuilder();
    private static final StorageComponentBuilder storageComponentBuilder = new StorageComponentBuilder();
    private static final VideoCardComponentBuilder videoCardComponentBuilder = new VideoCardComponentBuilder();


    private BuilderFactory() {
    }

    public static MotherboardComponentBuilder getMotherboardComponentBuilder() {
        return motherboardComponentBuilder;
    }

    public static ProcessorComponentBuilder getProcessorComponentBuilder() {
        return processorComponentBuilder;
    }

    public static MemoryComponentBuilder getMemoryComponentBuilder() {
        return memoryComponentBuilder;
    }

    public static PowerSupplyComponentBuilder getPowerSupplyComponentBuilder() {
        return powerSupplyComponentBuilder;
    }

    public static StorageComponentBuilder getStorageComponentBuilder() {
        return storageComponentBuilder;
    }

    public static VideoCardComponentBuilder getVideoCardComponentBuilder() {
        return videoCardComponentBuilder;
    }
}
