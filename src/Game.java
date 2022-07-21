import Map.*;
import Pjs.*;


import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private Map map;
    private ArrayList<Unit> unitsInOrderOfActions;
    public Game() {

        this.map = new Map();

        Melee melee11 = new Melee(MeleeLevels.LEVEL1, Players.PLAYER1);
        Melee melee12 = new Melee(MeleeLevels.LEVEL1, Players.PLAYER1);
        Melee melee13 = new Melee(MeleeLevels.LEVEL1, Players.PLAYER1);
        Ranged range11 = new Ranged(RangeLevels.LEVEL1, Players.PLAYER1);
        Ranged range12 = new Ranged(RangeLevels.LEVEL1, Players.PLAYER1);
        Ranged range13 = new Ranged(RangeLevels.LEVEL1, Players.PLAYER1);
        Melee melee21 = new Melee(MeleeLevels.LEVEL1, Players.PLAYER2);
        Melee melee22 = new Melee(MeleeLevels.LEVEL1, Players.PLAYER2);
        Ranged range21 = new Ranged(RangeLevels.LEVEL1, Players.PLAYER2);

        //map.setUnit(melee1, 1,1);
        map.setUnit(melee11, 0, 2);
        map.setUnit(melee12, 1, 2);
        map.setUnit(melee13, 1, 5);
        map.setUnit(melee21, 2, 3);
        map.setUnit(melee22, 2, 2);
        map.setUnit(range21, 4, 0);

        this.unitsInOrderOfActions = getUnitsInOrderOfActions();

        beginGame();


    }

    private ArrayList<Unit> getUnitsInOrderOfActions() {
        ArrayList<Unit> allUnits = new ArrayList<Unit>();
        for (int i = 0; i < this.map.getWIDTH(); i++) {
            for (int j = 0; j < this.map.getHEIGHT(); j++) {
                if (this.map.thereIsUnit(i, j)) {
                    allUnits.add(this.map.getUnit(i, j));
                }
            }
        }

        ArrayList<Double> speeds = new ArrayList<Double>();
        for (int i = 0; i < allUnits.size(); i++) {
            speeds.add(allUnits.get(i).getSpeed());
        }

        Collections.sort(speeds, Collections.reverseOrder());

        ArrayList<Unit> allUnitsOrdered = new ArrayList<Unit>();
        for (int i = 0; i < speeds.size(); i++) {
            for (int j = 0; j < allUnits.size(); j++) {
                if (allUnits.get(j).getSpeed() == speeds.get(i)) {
                    allUnitsOrdered.add(allUnits.get(j));
                }
            }
        }

        return allUnitsOrdered;
    }


    private boolean thereIsUnitsAlifeForBothPlayers() {
        boolean player1 = false;
        boolean player2 = false;

        for (int i = 0; i < this.map.getWIDTH(); i++) {
            for (int j = 0; j < this.map.getHEIGHT(); j++) {
                if (this.map.thereIsUnit(i, j)) {
                    if (this.map.getUnit(i, j).getPlayer() == Players.PLAYER1) {
                    player1 = true;}
                    if (this.map.getUnit(i, j).getPlayer() == Players.PLAYER2) {
                    player2 = true;}
                }
                if (player1 && player2) {
                    return true;
                }
            }
        }

        return false;
    }

    private void beginGame() {

        this.map.checkMap();
        showLifes();

        while (thereIsUnitsAlifeForBothPlayers()) {

            for (int i = 0; i < this.unitsInOrderOfActions.size(); i++) {
                unitsInOrderOfActions.get(i).action();
            }
            this.map.checkMap();
            showLifes();

        }

        System.out.println("El game ha terminado");
    }

    private void showLifes(){
        for (int i = 0; i < this.unitsInOrderOfActions.size(); i++) {
            System.out.println("La unidad del jugador "+ unitsInOrderOfActions.get(i).getPlayer().getNum()
            + " tiene " + unitsInOrderOfActions.get(i).getLife() + "  vida");
        }

    }

}
