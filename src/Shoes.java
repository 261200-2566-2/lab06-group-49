public class Shoes implements Accessories{
    protected String name;
    protected String className;
    protected double defense, s;

    //constructor รับชื่อและพลังป้องกันเริ่มต้นของรองเท้า
    Shoes(String name, double s){
        this.name = name;
        className = "Shoes";
        this.s = s;
    }
    @Override //function update พลังป้องกันของรองเท้า
    public void upState() { // //update defense ของรองเท้า (พลังป้องกันของผู้เล่นเพิ่มขึ้น)
        defense += s;
    }

    //function ส่งค่าพลังป้องกันของรองเท้า
    public double getDefenseShoes() {
        upState();
        return defense;
    }

    @Override
    public String getClassName() { //แสดงชื่อประเภทของ Accessories นี้ ในที่นี้คือ "Shoes"
        return className;
    }

    @Override
    public String getName() {
        return name;
    }
}