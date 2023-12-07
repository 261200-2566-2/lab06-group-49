public class Main {
    public static void main(String[] args) {
        lab05.test();
    }

    static class lab05 {
        static void test() {
            fighter F1 = new fighter("F1", 1, 20, 10, 3);
            carry C1 = new carry("C1", 1, 35, 10, 2);
            Sword sw1 = new Sword(5, 50);
            Sword sw2 = new Sword(1, 10);
            Shield sh1 = new Shield(10, 20);
            Ring r1 = new Ring("r1", 10);
            Shoes s1 = new Shoes("s1", 20);

            F1.showState();
            C1.showState();

            F1.equipSword(sw2);
            F1.showState();

            F1.attack(C1);
            C1.showState();

            C1.equipSword(sw1);
            F1.equipShield(sh1);
            F1.level_up();
            sw2.level_up();
            F1.showState();
            C1.showState();

            F1.attack(C1);
            C1.attack(F1);
            F1.showState();
            C1.showState();

            C1.unequipSword();
            C1.showState();

            C1.equipRing(r1);
            C1.showState();

            F1.equipShoes(s1);
            C1.attack(F1);
            F1.showState();

            F1.unequipSword();
            F1.unequipShield();
            F1.showState();
        }
    }
}







