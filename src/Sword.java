public class Sword {
    protected int level;
    protected double damage, d;

    //constructor รับ level และพลังโจมตีเริ่มต้นของดาบ
    Sword(int level, double d) {
        this.level = level;
        this.d = d;
        update_state();
    }

    public int getLevelSword(){
        return level;
    }

    public double getDamageSword(){
        return damage;
    }

    public void level_up(){
        level++;
        update_state();
    }

    //คิด damage จาก level ของดาบ ทำให้พลังโจมตีของตัวละครเพิ่มขึ้น
    private void update_state(){
        damage = d * (1 + 0.1 * (level - 1));
    }
}