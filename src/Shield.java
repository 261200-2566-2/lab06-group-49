public class Shield {
    protected int level;
    protected double defense, s;

    //constructor รับ level และพลังป้องกันเริ่มต้นของโล่
    Shield(int level, int s){
        this.level = level;
        this.s = s;
        update_state();
    }

    public int getLevelShield(){
        return level;
    }

    public double getDefenseShield(){
        return defense;
    }

    public void level_up(){
        level++;
        update_state();
    }

    //คิด defense จาก level ของโล่ ทำให้พลังป้องกันของตัวละครเพิ่มขึ้น
    private void update_state(){ defense = s * (1 + 0.05 * (level - 1)); }
}