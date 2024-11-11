package component;

import builder.ComputerSystemBuilder;
import checker.CompatibilityCheckerInterface;
import checker.FormFactorChecker;
import checker.PowerChecker;
import checker.SocketChecker;

import java.util.List;

public class ComputerSystem {
    List<ComponentInterface> components;

    public ComputerSystem(ComputerSystemBuilder computerSystemBuilder) {
        this.components = computerSystemBuilder.getComponents();
    }

    public List<ComponentInterface> getComponents() {
        return components;
    }

    public void setComponents(List<ComponentInterface> components) {
        this.components = components;
    }

    public String check() {
        CompatibilityCheckerInterface powerChecker = new PowerChecker();
        CompatibilityCheckerInterface socketChecker = new SocketChecker();
        CompatibilityCheckerInterface formFactorChecker = new FormFactorChecker();

        socketChecker.setNextChecker(formFactorChecker);
        powerChecker.setNextChecker(socketChecker);

        return powerChecker.checkCompatibility(components);
    }
}
