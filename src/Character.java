public interface Character { //ประกาศ interface ที่ชื่อว่า Character
    void showState(); //แสดงข้อมูลต่าง ๆ ของผู้เล่น
    void attack(char_ p); //function โจมตี
    void level_up(); //เพิ่ม level ของผู้เล่น
    void takeDamage(double d); //function แสดงค่าพลังชีวิตหลังจากถูกโจมตี
}