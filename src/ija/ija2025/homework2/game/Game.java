package ija.ija2025.homework2.game;

import ija.ija2025.homework2.common.Position;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @class Game
 * @brief The main class holding values of teh current game
 */
public class Game {

    // The values held by the class
    private Terrain[][] map; ///< The map of the game
    private Map<Position, Unit> units_map = new HashMap<>(); ///< Position to unit

    
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
     * @brief Create a new unit within the game
     * 
     * @param type The unit type -> Infantry/Tannk/artilerry
     * @param owner Who wons this unit within the game
     * @param row On which row the unit stands
     * @param column On which column the unit stands
     * 
     * @return The newly created Unit within the game.
     */
    public Unit createUnit(String type, String owner, int row, int column) {
        // Get the unit values based on its type
        UnitType unit_type = UnitType.convert(type);
        // Set its position
        Position position = new Position(row, column);

        // Check that the position is not yet occupied
        // If the position has key (something is "standing" on it)
        if (units_map.containsKey(position)) {
            throw new IllegalArgumentException("Map position is already occupied");
        }

        // Create the unit if all passes
        Unit unit = new Unit(unit_type, owner, position);
        // Set the unit position within the game
        units_map.put(position, unit);

        return unit;
    }

    /**
     * @brief Given the current position, perform weighted pathfinding and find all the reachbale positions viable
     * 
     * @param pos The position of the unit
     */
    public List<Position> getReachableTiles(Position pos) {
        // Check that the unit is even at the position
        Unit unit = this.units_map.get(pos);
        if (unit == null) {
            // Return a list of nothing -> No unit, can't go anywhere
            return List.of();
        }

        // Initialize the values for search
        // The map of the reachable positions with the best cost possible
        Map<Position, Integer> best = new HashMap<>();
        // The search queu to explore -> Djikstra
        PriorityQueue<SearchNode> frontier = new PriorityQueue<>(new SearchNodeComparator());
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
