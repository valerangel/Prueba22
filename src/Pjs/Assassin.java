package Pjs;
import Map.*;

import java.util.ArrayList;

public class Assassin extends Unit{

    private boolean canJump;


    public Assassin(AssassinLevels level, Players player) {
        super(level.getLevel(),level.getLife(), level.getDamage(), level.getRangeOfAttack(), level.getSpeed(), player);
        this.canJump = true;
    }

    public void action() {
        if (!this.isAlive) {//Check if unit is alive
            return;
        }

        if(canJump){
            jumpToBackline();
            canJump= false;
        }

        super.action();
    }

    private void jumpToBackline(){
        ArrayList<Cell> enemies = this.map.getEnemyPositions(player.getNum());

        Unit enemy = getFartestEnemy(enemies);
        jumpToEnemy(enemy);
    }

    private Unit getFartestEnemy(ArrayList<Cell> enemies){
        int maxDistance =0;
        int numEnemy=0;

        for (int i = 0; i < enemies.size(); i++) {
            if(super.distanceToUnit(enemies.get(i).getUnit())> maxDistance){
                maxDistance = super.distanceToUnit(enemies.get(i).getUnit());
                numEnemy = i;
            }
        }
        return enemies.get(numEnemy).getUnit();

    }

    private void jumpToEnemy (Unit enemy){
        int enX = enemy.getX();
        int enY = enemy.getY();

        if(this.map.thereIsCell(enX, enY+1)){
            if(!this.map.thereIsUnit(enX, enY+1)){
                this.map.moveUnit(this, x, y, enX, enY+1);
                return;
            }
        }

        if(this.map.thereIsCell(enX, enY-1)){
            if(!this.map.thereIsUnit(enX, enY-1)){
                this.map.moveUnit(this, x, y, enX, enY-1);
                return;
            }
        }

    }


    public String getType(){
        return "A";
    }


}
