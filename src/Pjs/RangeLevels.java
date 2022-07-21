package Pjs;

public enum RangeLevels {
    LEVEL1(1, 12, 3, 3, 4),
    LEVEL2(2, 14, 4, 3, 4),
    LEVEL3(3, 26, 5, 3, 5);
    private int level;
    private int life;
    private int damage;
    private int rangeOfAttack;
    private double speed;

    RangeLevels(int level, int life, int damage, int rangeOfAttack, double speed) {
        this.level = level;
        this.life = life;
        this.damage = damage;
        this.rangeOfAttack = rangeOfAttack;
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
        return speed + 7 * Math.random();
    }

    public int getRangeOfAttack() {
        return this.rangeOfAttack;
    }
}
