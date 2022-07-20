package Pjs;

public enum RangeLevels {
    LEVEL1(1, 12, 3, 4 + 7 * Math.random()),
    LEVEL2(2, 14, 4, 4 + 7 * Math.random()),
    LEVEL3(3, 26, 5, 5 + 7 * Math.random());
    private int level;
    private int life;
    private int damage;
    private double speed;

    RangeLevels(int level, int life, int damage, double speed) {
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
