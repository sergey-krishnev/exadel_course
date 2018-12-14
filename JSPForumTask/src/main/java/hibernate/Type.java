package hibernate;

public class Type {
    private static String typePosition;

    public static String getTypePosition() {
        return typePosition;
    }

    public static void setTypePosition(String typePosition) {
        Type.typePosition = typePosition;
    }
}
