import Map.*;
import Pjs.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Game {

    private final Map map;
    private final ArrayList<Unit> unitsInOrderOfActions;
    public Game() {

        this.map = new Map();

        Melee melee11 = new Melee(MeleeLevels.LEVEL1, Players.PLAYER1);
        Melee melee12 = new Melee(MeleeLevels.LEVEL1, Players.PLAYER1);
        Melee melee13 = new Melee(MeleeLevels.LEVEL1, Players.PLAYER1);

        Assassin assassin11 = new Assassin(AssassinLevels.LEVEL1, Players.PLAYER1);

        Ranged range11 = new Ranged(RangeLevels.LEVEL1, Players.PLAYER1);
        Ranged range12 = new Ranged(RangeLevels.LEVEL1, Players.PLAYER1);
        Ranged range13 = new Ranged(RangeLevels.LEVEL1, Players.PLAYER1);

        Melee melee21 = new Melee(MeleeLevels.LEVEL1, Players.PLAYER2);
        Melee melee22 = new Melee(MeleeLevels.LEVEL1, Players.PLAYER2);
        Ranged range21 = new Ranged(RangeLevels.LEVEL1, Players.PLAYER2);

        //map.setUnit(melee1, 1,1);
        map.setUnit(assassin11, 0, 2);
        map.setUnit(melee12, 1, 2);
        map.setUnit(melee13, 1, 5);
        map.setUnit(melee21, 2, 3);
        map.setUnit(melee22, 2, 2);
        map.setUnit(range21, 4, 3);

        this.unitsInOrderOfActions = getUnitsInOrderOfActions();

        beginGame();


    }

    private ArrayList<Unit> getUnitsInOrderOfActions() {
        ArrayList<Unit> allUnits = new ArrayList<>();
        for (int i = 0; i < this.map.getWIDTH(); i++) {
            for (int j = 0; j < this.map.getHEIGHT(); j++) {
                if (this.map.thereIsUnit(i, j)) {
                    allUnits.add(this.map.getUnit(i, j));
                }
            }
        }

        allUnits.sort(Comparator.comparingDouble(Unit::getSpeed).reversed());

        return allUnits;
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

        int loopCounter=0;

        while (thereIsUnitsAlifeForBothPlayers() && loopCounter<10) {

            for (Unit unitsInOrderOfAction : this.unitsInOrderOfActions) {
                unitsInOrderOfAction.action();
            }
            this.map.checkMap();
            showLifes();

            loopCounter++;
        }

        System.out.println("El game ha terminado");
    }

    private void showLifes(){
        for (Unit unitsInOrderOfAction : this.unitsInOrderOfActions) {
            System.out.println("La unidad del jugador " + unitsInOrderOfAction.getPlayer().getNum()
                    + " tiene " + unitsInOrderOfAction.getLife() + "  vida");
        }

    }

}
