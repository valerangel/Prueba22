package Map;

import Pjs.*;

import java.util.ArrayList;

public class Map {

    private final int WIDTH = 6;
    private final int HEIGHT = 6;

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
        cells[x][y] = new Cell(unit);
        unit.setMap(this, x, y);
    }

    public void checkMap() {
        System.out.println("\nChecking the map:");

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {

                if (cells[i][j].getTypeOfCell() == TypeOfCell.EMPTYCELL) {
                    System.out.print(". ");
                }
                if (cells[i][j].getTypeOfCell() == TypeOfCell.WITH_UNIT) {
                    if (cells[i][j].getUnit().getPlayer() == Players.PLAYER1) {
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

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if (cells[i][j].getTypeOfCell() == TypeOfCell.WITH_UNIT) {
                    if (cells[i][j].getUnit().getPlayer() == enemyPlayer)
                        enemies.add(cells[i][j]);
                }
            }

        }

        return enemies;
    }

    public void removeUnit(int x, int y) {
        this.cells[x][y] = new Cell(null);
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public boolean thereIsUnit(int x,int y){
        return this.cells[x][y].getTypeOfCell() == TypeOfCell.WITH_UNIT;
    }

    public Unit getUnit(int x, int y){
        return this.cells[x][y].getUnit();
    }
}
