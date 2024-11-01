package component;
/**
 * Базовый класс компонента
 * @author peya8bachey
 * @version 1.0
 */
public class Component implements ComponentInterface {
    /** Идентификатор компонента */
    long id;
    /** Наименование компонента */
    String model;
    /** Производитель компонента */
    String manufacturer;

    public Component(String model, String manufacturer) {
        this.model = model;
        this.manufacturer = manufacturer;
        id = IdGenerator.INSTANCE.generateId();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "component manufacturer='%s' model='%s'".formatted(manufacturer, model);
    }
}
