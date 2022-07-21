package Pjs;

public enum MeleeLevels {
    LEVEL1(1, 14, 5, 1, 7),
    LEVEL2(2, 15, 5, 1, 7),
    LEVEL3(3, 20, 5, 1, 7);
    private int level;
    private int life;
    private int damage;
    private int rangeOfAttack;
    private double speed;

    MeleeLevels(int level, int life, int damage, int rangeOfAttack, double speed) {
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

    public int getRangeOfAttack() {
        return rangeOfAttack;
    }

    protected double getSpeed() {
        return speed + 7 * Math.random();
    }
}
