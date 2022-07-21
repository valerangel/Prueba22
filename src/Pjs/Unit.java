package Pjs;

import Map.*;

import java.util.ArrayList;

public abstract class Unit {
    protected int level;
    protected int life;
    protected int damage;
    protected double speed;

    protected int rangeOfAttack;
    protected Players player;

    protected Map map;
    protected int x;
    protected int y;

    protected boolean isAlive;

    public Unit(int level, int life, int damage, int rangeOfAttack, double speed, Players player) {
        this.level = level;
        this.life = life;
        this.damage = damage;
        this.rangeOfAttack = rangeOfAttack;
        this.speed = speed;
        this.player = player;
        this.isAlive = true;
    }


    public void setMap(Map map, int x, int y) {
        this.map = map;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Players getPlayer() {
        return player;
    }

    public void dealDamage(int dmg) {
        this.life -= dmg;
        checkForDead();
    }

    public void checkForDead() {
        if (this.life <= 0) {
            this.isAlive = false;
            this.map.removeUnit(this.x, this.y);
        }
    }


    public int getLife() {
        return this.life;
    }

    public double getSpeed() {
        return this.speed;
    }

    public int distanceToUnit(Unit unit) {
        //We use the Chebyshev distance, i.e., the maximum between the x distance and y distance
        return Math.max(Math.abs(unit.getX() - this.x), Math.abs(unit.getY() - this.y));
    }



    public void action() {
        if(!this.isAlive) return;

        ArrayList<Cell> enemies = this.map.getEnemyPositions(player.getNum());
        if(enemyAtAttackDistance(enemies)){
            attackNearest(enemies);
            return;
        }
        lookForMovement(enemies);
    }

    private void attackNearest(ArrayList<Cell> enemies){
        for (int distance = 1; distance < rangeOfAttack+1; distance++) { //We search from nearest distance to the furthest.

            for (int i = 0; i < enemies.size() ; i++) { //We search if there is an enemy at the distance given.
                if(distanceToUnit(enemies.get(i).getUnit())<= distance){
                    enemies.get(i).getUnit().dealDamage(this.damage);
                    return;
                }
            }

        }
    }

    private boolean enemyAtAttackDistance(ArrayList<Cell> enemies){
        if (enemies.isEmpty()) return false;

        for (int i = 0; i < enemies.size(); i++) {
            if(distanceToUnit(enemies.get(i).getUnit())<= rangeOfAttack){
                return true;
            }
        }

        return false;
    }


    public void lookForMovement(ArrayList<Cell> enemies){
        if (enemies.isEmpty()) return;

        //We look for the nearest enemy
        int minimumDistance = 100;
        int enemyNumber=0;
        for (int i = 0; i < enemies.size() ; i++) {
            int distance = distanceToUnit(enemies.get(i).getUnit());
            if(distance < minimumDistance){
                minimumDistance = distance;
                enemyNumber = i;
            }
        }

        moveToEnemy(enemies.get(enemyNumber));
    }

    private void moveToEnemy(Cell enemy){
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

        if(!this.map.thereIsUnit(newX, newY)){
            moveTo(newX, newY);
            return;
        }

        if(!this.map.thereIsUnit(x, newY)){
            moveTo(x, newY);
            return;
        }

        if(!this.map.thereIsUnit(newX, y)){
            moveTo(newX, y);
            return;
        }


    }

    private void moveTo(int newX, int newY){
        this.map.removeUnit(x,y);
        this.map.setUnit(this, newX, newY);
    }


}
