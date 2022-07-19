import Map.*;
import Pjs.Melee;
import Pjs.MeleeLevels;
import Pjs.Players;

public class Main {
    public static void main(String[] args){
        System.out.println("Esto funcionará?");

        Map map = new Map();

        Melee melee1 = new Melee(MeleeLevels.LEVEL1, Players.PLAYER1);
        Melee melee2 = new Melee(MeleeLevels.LEVEL1, Players.PLAYER2);

        map.setUnit(melee1, 1, 1);
        map.setUnit(melee2, 1, 3);

        map.checkMap();


        melee2.action();
        map.checkMap();
        System.out.println("el 1 tiene "+melee1.getLife()+ "  vida");
        System.out.println("el 2 tiene "+melee2.getLife()+ "  vida");


        melee1.action();
        map.checkMap();
        System.out.println("el 1 tiene "+melee1.getLife()+ "  vida");
        System.out.println("el 2 tiene "+melee2.getLife()+ "  vida");


        melee2.action();
        map.checkMap();
        System.out.println("el 1 tiene "+melee1.getLife()+ "  vida");
        System.out.println("el 2 tiene "+melee2.getLife()+ "  vida");


        melee1.action();
        map.checkMap();
        System.out.println("el 1 tiene "+melee1.getLife()+ "  vida");
        System.out.println("el 2 tiene "+melee2.getLife()+ "  vida");


        melee2.action();
        map.checkMap();
        System.out.println("el 1 tiene "+melee1.getLife()+ "  vida");
        System.out.println("el 2 tiene "+melee2.getLife()+ "  vida");


        melee1.action();
        map.checkMap();
        System.out.println("el 1 tiene "+melee1.getLife()+ "  vida");
        System.out.println("el 2 tiene "+melee2.getLife()+ "  vida");



    }
}
