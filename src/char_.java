public class char_ implements Character{
    protected String name;
    protected int level;
    protected double max_hp, hp, max_mana, mana, d, damage, r, max_speed, s, defense;
    protected Shield e_shield;
    protected Sword e_sword;
    protected Ring e_ring;
    protected Shoes e_shoes;

    public char_(String name,int level,double d, double s,double r){
        this.name = name; //ชื่อของผู้เล่น
        this.level = level; //level ของผู้เล่น
        this.d = d; //พลังโจมตีของผู้เล่น
        this.s = s; //พลังป้องกันของผู้เล่น
        this.r = r; //ค่าความเร็วพื้นฐานของผู้เล่น (base speed)
        hp = 100 + 10*(level-1); //ค่าพลังชีวิตของผู้เล่น
        mana = 50 + 2*(level-1); //ค่าพลังเวทมนตร์ของผู้เล่น
        e_sword = null; //ไม่ถือดาบ
        e_shield = null; //ไม่ถือโล่
        e_ring = null; //ไม่ใส่แหวน
        e_shoes = null; //ไม่ใส่รองเท้า
    }

    private void update_state(){
        max_hp = 100 + 10*(level-1); //ค่า max hp ของผู้เล่น
        max_mana = 50 + 2*(level-1); //ค่า max mana ของผู้เล่น
        max_speed = r + (r * (0.1 + 0.03*(level-1))); //ค่า max speed ของผู้เล่น
        damage = d * (1 + 0.1*(level-1)); //ค่า damage (โจมตี)
        defense = s * (1 + 0.05*(level-1)); //ค่า defense (ป้องกัน)
        if(e_sword != null){ //ถ้าผู้เล่นถือดาบ
            damage = damage + e_sword.getDamageSword(); //พลังโจมตีเพิ่มขึ้น
            max_speed -= (0.1 + 0.04*e_sword.getLevelSword()); //ค่า max speed ลดลง
        }
        if(e_shield != null){ //ถ้าผู้เล่นถือโล่
            defense = defense + e_shield.getDefenseShield(); //พลังป้องกันเพิ่มขึ้น
            max_speed -= (0.1 + 0.08*e_shield.getLevelShield()); //ค่า max speed ลดลง
        }
        if(e_ring != null){ //ถ้าผู้เล่นใส่แหวน
            damage = damage + e_ring.getDamageRing(); //พลังโจมตีเพิ่มขึ้น
        }
        if(e_shoes != null){ //ถ้าผู้เล่นใส่รองเท้า
            defense = defense + e_shoes.getDefenseShoes(); //พลังป้องกันเพิ่มขึ้น
        }
        if(max_speed < 0 ){ //ถ้าค่า max speed น้อยกว่า 0
            max_speed = 0; //set max speed = 0
        }
    }

    public void equipSword(Sword sword){ //function ถือดาบ
        unequipSword(); //เรียกใช้ function unequipSword() ก่อน (วางดาบก่อน)
        e_sword = sword;
    }

    public void unequipSword() { e_sword = null;} //function วางดาบ

    public void equipShield(Shield shield){ //function ถือโล่
        unequipShield(); //เรียกใช้ function unequipShield() ก่อน (วางโล่ก่อน)
        e_shield = shield;
    }

    public void unequipShield() { e_shield = null;} //function วางโล่

    public void equipRing(Ring ring) {
        unequipRing(); //เรียกใช้ function unequipRing() ก่อน
        e_ring = ring;
    }

    public void unequipRing() { e_ring = null; } //function เลิกใช้แหวน

    public void equipShoes(Shoes shoes) {
        unequipShoes(); //เรียกใช้ function unequipShoes() ก่อน
        e_shoes = shoes;
    }

    public void unequipShoes() { e_shoes = null; } //function เลิกใช้รองเท้า

    @Override
    public void showState() {
        update_state(); //เรียกใช้ function update_state() เพื่อ update ค่าต่างๆ แล้วแสดงค่านั้น
        System.out.println("|<------------------------------>|");
        System.out.println("    Name : " + name + " (Level " + level + ")");
        System.out.println("    HP/Max Hp ❤\uFE0F : " + hp + "/" + max_hp);
        System.out.println("    Mana/Max Mana \uD83D\uDC99: " + mana + "/" + max_mana);
        System.out.println("    Base Speed : " + r);
        System.out.println("    Max Speed : " + max_speed);
        System.out.println("    Damage \uD83D\uDDE1\uFE0F: " + damage);
        System.out.println("    Defense \uD83D\uDEE1\uFE0F: " + defense);
        if(e_sword != null){ //ถ้าผู้เล่นถือดาบ
            System.out.println("    equipSword");
        }
        if(e_shield != null){ //ถ้าผู้เล่นถือโล่
            System.out.println("    equipShield");
        }
        if(e_ring != null){ //ถ้าผู้เล่นใช้แหวน
            System.out.println("    equipRing");
        }
        if(e_shoes != null){ //ถ้าผู้เล่นใช้รองเท้า
            System.out.println("    equipShoes");
        }
        System.out.println("|<------------------------------>|");
        System.out.println(" ");
    }

    @Override
    public void attack(char_ p){ p.takeDamage(damage); } //function โจมตี

    @Override
    public void level_up() { level++; } //เพิ่ม level ของผู้เล่น


    @Override
    public void takeDamage(double d){ //function แสดงค่าพลังชีวิตหลังจากถูกโจมตี
        double dam = defense - d; //ค่าความเสียหาย = ค่าพลังป้องกัน - ค่าพลังโจมตีที่ได้รับ
        if(e_shoes != null){ // ถ้า e_shoes มีค่าไม่ใช่ null
            dam /= 2; // จะทำการลดค่าความเสียหายลงครึ่งหนึ่ง
        }
        if(dam > 0){ //ถ้าค่าความเสียหาย > 0 (defense > d)
            dam = 0; //ให้ค่าความเสียหายเป็น 0
        }
        hp += dam; //ค่าพลังชีวิตลดลง (ค่าความเสียหายต้องติดลบ เนื่องจากถูกโจมตี)
        if(hp < 0){ //ถ้าค่าพลังชีวิต น้อยกว่า 0
            hp = 0; //ให้ค่าพลังชีวิตเหลือ 0
        }
    }
}