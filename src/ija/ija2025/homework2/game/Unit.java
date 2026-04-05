package ija.ija2025.homework2.game;

import ija.ija2025.homework2.common.Position;

public class Unit {

    // Values of the class
    private UnitType unitType; ///< the type of the unit
    private String owner; ///< the owner of the unit
    private Position position; ///< Where the unit is currently located
    private int current_hp; ///< What is the current hp of the unit

    /**
     * @brief Constructor of the Unit class. The hp is initialised at maximum.
     * 
     * @param unitType The type of the unit
     * @param owner The owner of the unit
     * @param position Where the unt is located on the game map
     */
    public Unit(UnitType unitType, String owner, Position position) {
        this.unitType = unitType;
        this.owner = owner;
        this.position = position;
        this.current_hp = unitType.getMaxHP();
    }

}
