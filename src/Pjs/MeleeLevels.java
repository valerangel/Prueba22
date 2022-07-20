package Pjs;

public enum MeleeLevels {
    LEVEL1(1, 12, 5, 7 + 7 * Math.random()),
    LEVEL2(2, 15, 5, 7 + 7 * Math.random()),
    LEVEL3(3, 20, 5, 7 + 7 * Math.random());
    private int level;
    private int life;
    private int damage;
    private double speed;

    MeleeLevels(int level, int life, int damage, double speed) {
        this.level = level;
        this.life = life;
        this.damage = damage;
        this.speed = speed;
    }

    protected int getLevel() {
        return level;
    }

    protected int getLife() {
        return life;
    }

    protected int getDamage() {
        return damage;
    }

    protected double getSpeed() {
        return speed;
    }
}
