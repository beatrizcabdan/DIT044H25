package W46Inheritance;

// final boss, therefore can't be extended
final class Boss {
    public void bossAround() {
        System.out.println("Boss around");
    }
}

// gameboss can't extend boss because it is final
class GameBoss {
    public void bossAround() {
        System.out.println("Boss around");
    }
}

public class Example3 {
    public static void main(String[] args) {
        Boss boss = new Boss();
        GameBoss boss1 = new GameBoss();

        boss.bossAround();
        boss1.bossAround();
    }
}
