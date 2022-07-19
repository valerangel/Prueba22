package Pjs;
import Map.*;

public abstract class Unit {
    protected int level;
    protected int life;
    protected int damage;
    protected int speed;

    protected Players player;

    protected Map map;
    protected int x;
    protected int y;

    protected boolean isAlive;

    public Unit (int level, int life, int damage, int speed, Players player){
        this.level = level;
        this.life = life;
        this.damage = damage;
        this.speed= speed;
        this.player = player;
        this.isAlive = true;
    }

    public abstract void action();

    public abstract void setMap(Map map, int x, int y);
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public Players getPlayer(){
        return player;
    }

    public abstract void dealDamage(int dmg);



    public int getLife(){
        return this.life;
    }
}
