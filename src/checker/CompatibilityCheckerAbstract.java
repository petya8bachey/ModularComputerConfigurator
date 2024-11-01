package checker;

import component.ComponentInterface;

import java.util.List;

public abstract class CompatibilityCheckerAbstract implements CompatibilityCheckerInterface {
    CompatibilityCheckerInterface nextCompatibleChecker;

    @Override
    public void setNextChecker(CompatibilityCheckerInterface nextCompatibleChecker) {
        this.nextCompatibleChecker = nextCompatibleChecker;
    }

    @Override
    public final String checkCompatibility(List<ComponentInterface> components) {
        String result = performCheck(components);
        if (nextCompatibleChecker != null) {
            return "%s\n%s".formatted(result, nextCompatibleChecker.checkCompatibility(components));
        }
        return result;
    }

    protected abstract String performCheck(List<ComponentInterface> components);
}
