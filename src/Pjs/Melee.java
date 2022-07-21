package Pjs;
import Map.*;

import java.util.ArrayList;

public class Melee extends Unit{

    public Melee(MeleeLevels level, Players player) {
        super(level.getLevel(),level.getLife(), level.getDamage(), level.getRangeOfAttack(), level.getSpeed(), player);

    }

}
