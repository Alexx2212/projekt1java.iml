package projekt1java;

public interface Scientific {
    String getDomain();

    default boolean isTheSameDomain(Scientific res2) {
        if (res2 == null) {
            return false;
        }
        return this.getDomain().equalsIgnoreCase(res2.getDomain());
    }
}
