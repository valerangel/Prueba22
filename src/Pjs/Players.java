package Pjs;

public enum Players {
    PLAYER1(1),
    PLAYER2(2);

    private int num;

    Players(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
