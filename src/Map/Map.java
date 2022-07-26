package Map;

import Pjs.*;

import java.util.ArrayList;

public class Map {

    private final int WIDTH = 6;
    private final int HEIGHT = 8;

    private Cell[][] cells;

    public Map() {
        cells = new Cell[WIDTH][HEIGHT];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new Cell(null);
            }

        }
    }

    public void setUnit(Unit unit, int x, int y) {
        cells[x][y].setUnit(unit);
        unit.setMap(this, x, y);
    }

    public void checkMap() {
        System.out.println("\nChecking the map:");

        for (Cell[] cell : cells) {
            for (int j = 0; j < cells[0].length; j++) {

                if (cell[j].getTypeOfCell() == TypeOfCell.EMPTYCELL) {
                    System.out.print(" . ");
                }
                if (cell[j].getTypeOfCell() == TypeOfCell.WITH_UNIT) {
                    System.out.print(cell[j].getUnit().getType());
                    if (cell[j].getUnit().getPlayer() == Players.PLAYER1) {
                        System.out.print("1 ");
                    } else {
                        System.out.print("2 ");
                    }
                }
            }
            System.out.println();
        }
    }

    public ArrayList<Cell> getEnemyPositions(int player) {
        ArrayList<Cell> enemies = new ArrayList<Cell>();

        Players enemyPlayer;
        if (player == 1) {
            enemyPlayer = Players.PLAYER2;
        } else {
            enemyPlayer = Players.PLAYER1;
        }

        for (Cell[] cell : cells) {
            for (int j = 0; j < cells[0].length; j++) {
                if (cell[j].getTypeOfCell() == TypeOfCell.WITH_UNIT) {
                    if (cell[j].getUnit().isAlive()) {
                        if (cell[j].getUnit().getPlayer() == enemyPlayer)
                            enemies.add(cell[j]);
                    }
                }
            }

        }

        return enemies;
    }

    public void moveUnit(Unit unit, int x, int y, int newX, int newY){
        this.removeUnit(x,y);
        this.setUnit(unit, newX, newY);
    }

    public void removeUnit(int x, int y) {
        cells[x][y].setUnit(null);
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public boolean thereIsUnit(int x,int y){
        if(thereIsCell(x,y)) {
            return this.cells[x][y].getTypeOfCell() == TypeOfCell.WITH_UNIT;
        }

        return false;
    }

    public boolean thereIsCell(int x, int y){
        if(x >=0 && x< WIDTH && y >=0 && y < HEIGHT) {
            return true;
        }
        return false;
    }

    public Unit getUnit(int x, int y){
        return this.cells[x][y].getUnit();
    }
}
