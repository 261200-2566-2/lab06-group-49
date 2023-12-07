public class Main {
    public static void main(String[] args) {
        lab05.test();
    }

    static class lab05 {
        static void test() {
            fighter F1 = new fighter("F1", 1, 20, 10, 3); //สร้างผู้เล่น F1
            carry C1 = new carry("C1", 1, 35, 10, 2); //สร้างผู้เล่น C1
            Sword sw1 = new Sword(5, 50); //สร้างดาบ sw1
            Sword sw2 = new Sword(1, 10); //สร้างดาบ sw2
            Shield sh1 = new Shield(10, 20); //สร้างโล่ sh1
            Ring r1 = new Ring("r1", 10); //สร้างแหวน r1
            Shoes s1 = new Shoes("s1", 20); //สร้างรองเท้า s1

            F1.showState(); //แสดงข้อมูลของ F1
            C1.showState(); //แสดงข้อมูลของ C1

            F1.equipSword(sw2); //F1 ถือดาบ sw2
            F1.showState(); //แสดงข้อมูลของ F1

            F1.attack(C1); //F1 โจมตี C1
            C1.showState(); //แสดงข้อมูลของ C1

            C1.equipSword(sw1); //C1 ถือดาบ sw1
            F1.equipShield(sh1); //F1 ถือโล่ sh1
            F1.level_up(); //F1 level เพิ่มขึ้น
            sw2.level_up(); //ดาบ sw2 level เพิ่มขึ้น
            F1.showState(); //แสดงข้อมูลของ F1
            C1.showState(); //แสดงข้อมูลของ C1

            F1.attack(C1); //F1 โจมตี C1
            C1.attack(F1); //C1 โจมตี F1
            F1.showState(); //แสดงข้อมูลของ F1
            C1.showState(); //แสดงข้อมูลของ C1

            C1.unequipSword(); //C1 วางดาบ (sw1)
            C1.showState(); //แสดงข้อมูลของ C1

            C1.equipRing(r1); //C1 ใช้แหวน(r1)
            C1.showState(); //แสดงข้อมูลของ C1

            F1.equipShoes(s1); //F1 ใช้รองเท้า(s1)
            C1.attack(F1); //C1 โจมตี F1
            F1.showState(); //แสดงข้อมูลของ F1

            F1.unequipSword(); //F1 วางดาบ (sw2)
            F1.unequipShield(); //F1 วางโล่ (sh1)
            F1.showState(); //แสดงข้อมูลของ F1
        }
    }
}







