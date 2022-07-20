package Pjs;
import Map.*;

public abstract class Unit {
    protected int level;
    protected int life;
    protected int damage;
    protected double speed;

    protected Players player;

    protected Map map;
    protected int x;
    protected int y;

    protected boolean isAlive;

    public Unit (int level, int life, int damage, double speed, Players player){
        this.level = level;
        this.life = life;
        this.damage = damage;
        this.speed= speed;
        this.player = player;
        this.isAlive = true;
    }

    public abstract void action();

    public void setMap(Map map, int x, int y){
        this.map = map;
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Players getPlayer(){
        return player;
    }

    public void dealDamage(int dmg){
        this.life -= dmg;
        checkForDead();
    }
    public void checkForDead(){
        if(this.life <=0){
            this.isAlive= false;
            this.map.removeUnit(this.x, this.y);
        }
    }


    public int getLife(){
        return this.life;
    }

    public double getSpeed(){
        return this.speed;
    }

}
