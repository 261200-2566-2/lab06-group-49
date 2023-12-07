public class Ring implements Accessories{
    protected String name;
    protected String className;
    protected double damage, d;

    Ring(String name, double d){
        this.name = name; //ชื่อของผู้เล่น
        className = "Ring";
        this.d = d; //พลังโจมตีเริ่มต้นของแหวน
    }

    @Override
    public void upState() { //update damage ของแหวน (พลังโจมตีของผู้เล่นเพิ่มขึ้น)
        damage = d*2;
    }

    public double getDamageRing() { //พลังโจมตีของแหวน
        upState();
        return damage;
    }

    @Override
    public String getClassName() {
        return className;
    } //แสดงชื่อประเภทของ Accessories นี้ ในที่นี้คือ "Ring"

    @Override
    public String getName() {
        return name;
    } //แสดงชิ่อผู้เล่นที่สวมใส่  Accessories นี้
}