package Map;

import Pjs.*;

import java.util.ArrayList;

public class Map {

    private Cell[][] cells;

    public Map() {
        cells = new Cell[6][4];
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
                    System.out.print(".");
                }
                if (cells[i][j].getTypeOfCell() == TypeOfCell.WITH_UNIT) {
                    if (cells[i][j].getUnit().getPlayer() == Players.PLAYER1) {
                        System.out.print("1");
                    } else {
                        System.out.print("2");
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

}
