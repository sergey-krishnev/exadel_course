package hibernate;

public class Type {
    private static String typePosition = "0";

    public static String getTypePosition() {
        return typePosition;
    }

    public static void setTypePosition(String typePosition) {
        Type.typePosition = typePosition;
    }
}
