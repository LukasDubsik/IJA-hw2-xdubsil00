package ija.ija2025.homework2.game;

import java.util.ArrayList;
import java.util.List;

public class GameFactory {
    
    /**
     * @brief Private constructor - static "class", makes it imposible to create as a class
     */
    private GameFactory() {

    }  

    public static Game createGame(String[] map) {
        // Check that the input is valid
        if (map == null || map.length == 0) {
            throw new IllegalArgumentException("Map can't be null or have zero length!");
        }

        // How many columns are there
        int columns = -1;
        // Holder for the Terrain after conversion
        List<Terrain[]> rows = new ArrayList<>();

        // Iterate through the map and process the values
        for (String row : map) {
            if (row == null) {
                throw new IllegalArgumentException("Unknow row value (null) of the map.");
            }

            String row_proc = row.trim();

            if (row_proc.isEmpty()) {
                throw new IllegalArgumentException("Map can't have empty rows.");
            }

            // Convert into individual fields - Split by whitaspaces
            String[] tokens = row_proc.split("\\s+");

            // Check the columns
            if (columns == -1) {
                columns = tokens.length;
            } else if (columns != tokens.length) {
                throw new IllegalArgumentException("Map must be rectangular.");
            }

            // Create Terrain array for this row
            Terrain[] row_terrain = new Terrain[columns];

            for (int i = 0; i < tokens.length; i++) {
                row_terrain[i] = Terrain.convert(tokens[i]);
            }

            // Push back into the general List holder
            rows.add(row_terrain);
        }

        if (rows.isEmpty()) {
            throw new IllegalArgumentException("Map can't be empty.");
        }

        // Create the final array holder of the map
        Terrain[][] board_terrain = rows.toArray(Terrain[][]::new);

        // Return the create game from the map
        return new Game(board_terrain);
    }
}
