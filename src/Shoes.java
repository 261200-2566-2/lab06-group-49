public class Shoes implements Accessories{
    protected String name;
    protected String className;
    protected double defense, s;

    Shoes(String name, double s){
        this.name = name; //ชื่อของผู้เล่น
        className = "Shoes";
        this.s = s; //พลังป้องกันเริ่มต้นของรองเท้า
    }
    @Override
    public void upState() { // //update defense ของรองเท้า (พลังป้องกันของผู้เล่นเพิ่มขึ้น)
        defense += s;
    }

    public double getDefenseShoes() { //พลังป้องกันของรองเท้า
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
    } //แสดงชิ่อผู้เล่นที่สวมใส่  Accessories นี้
}