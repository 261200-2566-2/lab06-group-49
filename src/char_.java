public class char_ implements Character{
    protected String name;
    protected int level;
    protected double max_hp, hp, max_mana, mana, d, damage, r, max_speed, s, defense;
    protected Shield e_shield;
    protected Sword e_sword;
    protected Ring e_ring;
    protected Shoes e_shoes;

    //constructor รับชื่อ, level, พลังโจมตี, พลังป้องกัน, ความเร็วพื้นฐาน เป็นค่าเริ่มต้นของตัวละคร
    public char_(String name,int level,double d, double s,double r){
        this.name = name;
        this.level = level;
        this.d = d;
        this.s = s;
        this.r = r;
        hp = 100 + 10*(level-1);
        mana = 50 + 2*(level-1);
        e_sword = null;
        e_shield = null;
        e_ring = null;
        e_shoes = null;
    }

    /* update ข้อมูลของตัวละคร โดยค่าพลังต่างๆจะมีการคำนวณโดยใช้ level ดาบ,โล่ ทำให้ความเร็วสูงสุดลดลง
    ดาบ,แหวน ทำให้พลังโจมตีของตัวละครเพิ่มขึ้น โล่,รองเท้า ทำให้พลังป้องกันของผู้เล่นมากขึ้น */
    private void update_state(){
        max_hp = 100 + 10*(level-1);
        max_mana = 50 + 2*(level-1);
        max_speed = r + (r * (0.1 + 0.03*(level-1)));
        damage = d * (1 + 0.1*(level-1));
        defense = s * (1 + 0.05*(level-1));
        if(e_sword != null){
            damage = damage + e_sword.getDamageSword();
            max_speed -= (0.1 + 0.04*e_sword.getLevelSword());
        }
        if(e_shield != null){
            defense = defense + e_shield.getDefenseShield();
            max_speed -= (0.1 + 0.08*e_shield.getLevelShield());
        }
        if(e_ring != null){
            damage = damage + e_ring.getDamageRing();
        }
        if(e_shoes != null){
            defense = defense + e_shoes.getDefenseShoes();
        }
        if(max_speed < 0 ){
            max_speed = 0;
        }
    }

    //function ให้ตัวละครถือดาบ ซึ่งจะลดค่า max_speed และเพิ่มพลังโจมตีของตัวละคร
    public void equipSword(Sword sword){
        unequipSword();
        e_sword = sword;
    }

    //function ให้ตัวละครวางดาบ ค่า max_speed และพลังโจมตีกลับมาเท่าเดิม
    public void unequipSword() { e_sword = null;}

    //function ให้ตัวละครถือโล่ ซึ่งจะลดค่า max_speed และเพิ่มพลังป้องกันของตัวละคร
    public void equipShield(Shield shield){
        unequipShield();
        e_shield = shield;
    }

    //function ให้ตัวละครวางโล่ ค่า max_speed และพลังป้องกันกลับมาเท่าเดิม
    public void unequipShield() { e_shield = null;}

    //function ให้ตัวละครใส่แหวน เมื่อใส่แล้วพลังโจมตีของตัวละครจะเพิ่มขึ้น
    public void equipRing(Ring ring) {
        unequipRing();
        e_ring = ring;
    }

    //function ให้ตัวละครถอดแหวน ทำให้พลังโจมตีกลับมาเท่าเดิม
    public void unequipRing() { e_ring = null; } //function เลิกใช้แหวน

    //function ให้ตัวละครใส่รองเท้า เมื่อใส่แล้วพลังป้องกันของตัวละครจะเพิ่มขึ้น
    public void equipShoes(Shoes shoes) {
        unequipShoes(); //เรียกใช้ function unequipShoes() ก่อน
        e_shoes = shoes;
    }

    //function ให้ตัวละครถอดรองเท้า ทำให้พลังป้องกันกลับมาเท่าเดิม
    public void unequipShoes() { e_shoes = null; } //function เลิกใช้รองเท้า

    @Override //function แสดงข้อมูลของตัวละคร
    public void showState() {
        update_state();
        System.out.println("|<------------------------------>|");
        System.out.println("    Name : " + name + " (Level " + level + ")");
        System.out.println("    HP/Max Hp ❤\uFE0F : " + hp + "/" + max_hp);
        System.out.println("    Mana/Max Mana \uD83D\uDC99: " + mana + "/" + max_mana);
        System.out.println("    Base Speed : " + r);
        System.out.println("    Max Speed : " + max_speed);
        System.out.println("    Damage \uD83D\uDDE1\uFE0F: " + damage);
        System.out.println("    Defense \uD83D\uDEE1\uFE0F: " + defense);
        if(e_sword != null){
            System.out.println("    equipSword");
        }
        if(e_shield != null){
            System.out.println("    equipShield");
        }
        if(e_ring != null){
            System.out.println("    equipRing");
        }
        if(e_shoes != null){
            System.out.println("    equipShoes");
        }
        System.out.println("|<------------------------------>|");
        System.out.println(" ");
    }

    @Override //function โจมตี โดยรับค่าเป็นตัวละครฝ่ายตรงข้าม
    public void attack(char_ p){ p.takeDamage(damage); }

    @Override
    public void level_up() { level++; }


    @Override //function รับพลังโจมตี ทำให้ hp ลดลง และหากผู้เล่นสวมรองเท้า ค่าความเสียหายที่ได้รับจะลดลงเหลือครึ่งหนึ่ง
    public void takeDamage(double d){
        double dam = defense - d;
        if(e_shoes != null){
            dam /= 2;
        }
        if(dam > 0){
            dam = 0;
        }
        hp += dam;
        if(hp < 0){
            hp = 0;
        }
    }
}