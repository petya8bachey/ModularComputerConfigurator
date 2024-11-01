package checker;

import component.ComponentInterface;

import java.util.List;

public interface CompatibilityCheckerInterface {
    void setNextChecker(CompatibilityCheckerInterface nextCompatibleChecker);
    String checkCompatibility(List<ComponentInterface> components);
}