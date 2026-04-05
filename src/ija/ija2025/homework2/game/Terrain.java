package ija.ija2025.homework2.game;

public enum Terrain {
    // List of the types and their names of the Terrain
    PLAIN("P"),
    FOREST("F"),
    MOUNTAIN("M"),
    WATER("W");

    private String val;

    Terrain(String val_) {
        this.val = val_;
    }

    public static Terrain convert(String type) {
        // Check that the input isn't null
        if (type == null || type.trim().length() != 0) {
            throw new IllegalArgumentException("Expected a single Letter input.");
        }

        // Attempt to normalie the string
        String type_proc = type.trim().toUpperCase();

        // Attempt to convert to the enum
        return switch (type_proc) {
            case "P" -> PLAIN;
            case "F" -> FOREST;
            case "M" -> MOUNTAIN;
            case "W" -> WATER;
            default -> throw new IllegalArgumentException("Unsupported terrain value: " + type_proc);
        };
    }
}
