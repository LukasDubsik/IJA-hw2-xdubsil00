package ija.ija2025.homework2.game;

import java.util.Arrays;

/**
 * @class Game
 * @brief The main class holding values of teh current game
 */
public class Game {

    // The values held by the class
    Terrain[][] map;
    
    /**
     * @brief The constructor of the Game class
     * 
     * @param map_ The array map - already converted to the Terrain enum
     */
    Game(Terrain[][] map_) {
        // Make sure the games are independent by copying the input map
        this.map = copyInputMap(map_);
    }

    /**
     * @brief Copies the incoming map into a new form to make sure the games stay independent
     * 
     * @param map_in The input map of Terrain enums
     * @return The copied map of the same type and form
     */
    private static Terrain[][] copyInputMap(Terrain[][] map_in) {
        // Create an empty holder of the same size
        Terrain[][] copy = new Terrain[map_in.length][];

        // Copy element by element
        for (int i = 0; i < map_in.length; i++) {
            copy[i] = Arrays.copyOf(map_in[i], map_in[i].length);
        }

        // Return the copied form
        return copy;
    }
}
