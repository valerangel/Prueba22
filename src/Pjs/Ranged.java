package Pjs;
import Map.*;

import java.util.ArrayList;

public class Ranged extends Unit{

    private final int rangeOfAttack = 3;

    public Ranged(RangeLevels level, Players player) {
        super(level.getLevel(),level.getLife(), level.getDamage(), level.getSpeed(), player);

    }

    @Override
    public void action() {
        ArrayList<Cell> enemies = this.map.getEnemyPositions(super.player.getNum());
        if(enemyAtDistance2(enemies)){
            attack(enemies);
            return;
        }
        lookForMovement(enemies);
    }


    private boolean enemyAtDistance2(ArrayList<Cell> enemies){
        for (int i = 0; i < enemies.size(); i++) {
            if(Math.abs(enemies.get(i).getUnit().getX() - super.x) <= rangeOfAttack
                    && Math.abs(enemies.get(i).getUnit().getY() - super.y) <= rangeOfAttack ){
                return true;
            }
        }
        return false;
    }

    private void attack(ArrayList<Cell> enemies){
        for (int j = 1; j < rangeOfAttack+1; j++) {
            for (int i = 0; i < enemies.size() ; i++) {
                if(Math.abs(enemies.get(i).getUnit().getX() - super.x) <= j
                        && Math.abs(enemies.get(i).getUnit().getY() - super.y) <= j ){
                    enemies.get(i).getUnit().dealDamage(super.damage);
                    return;
                }
            }
        }
    }

    public void lookForMovement(ArrayList<Cell> enemies){
        //We look for the nearest enemy
        int minimumDistance = 100;
        int enemyNumber=0;
        for (int i = 0; i < enemies.size() ; i++) {
            int distance = Math.min(Math.abs(enemies.get(i).getUnit().getX() - super.x),
                    Math.abs(enemies.get(i).getUnit().getY() - super.y));
            if(distance < minimumDistance){
                minimumDistance = distance;
                enemyNumber = i;
            }
        }

        moveToEnemy(enemies.get(enemyNumber));
    }

    private void moveToEnemy(Cell enemy){ //****Fata ver que no esté ocupada la casilla a la que se quiere ir.
        int newX = this.x;
        int newY = this.y;

        int enemyX = enemy.getUnit().getX();
        int enemyY = enemy.getUnit().getY();

        if(x < enemyX){
            newX++;
        }
        if(x > enemyX){
            newX--;
        }
        if(y < enemyY){
            newY++;
        }
        if(y > enemyY){
            newY--;
        }

        moveTo(newX, newY);
    }

    private void moveTo(int newX, int newY){
        this.map.removeUnit(x,y);
        this.map.setUnit(this, newX, newY);
    }

}
