package hibernate;

public class Type {
    private static String typePosition = "0";

    private static String typeName = "Query";

    public static String getTypePosition() {
        return typePosition;
    }

    public static void setTypePosition(String typePosition) {
        Type.typePosition = typePosition;
    }

    public static String getTypeName() {
        return typeName;
    }

    public static void setTypeName(String typeName) {
        Type.typeName = typeName;
    }
}
