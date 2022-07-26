package Pjs;
import Map.*;

import java.util.ArrayList;

public class Ranged extends Unit{

    public Ranged(RangeLevels level, Players player) {
        super(level.getLevel(),level.getLife(), level.getDamage(), level.getRangeOfAttack(), level.getSpeed(), player);

    }

    public String getType(){
        return "R";
    }

}
