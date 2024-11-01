package checker;

public abstract class CompatibilityCheckerAbstract implements CompatibilityCheckerInterface {
    CompatibilityCheckerInterface nextCompatibleChecker;
    @Override
    public void setNextChecker(CompatibilityCheckerInterface nextCompatibleChecker) {
        this.nextCompatibleChecker = nextCompatibleChecker;
    }
}
