public class Ring implements Accessories{
    protected String name;
    protected String className;
    protected double damage, d;

    //constructor รับชื่อและพลังโจมตีเริ่มต้นของแหวน
    Ring(String name, double d){
        this.name = name;
        className = "Ring";
        this.d = d;
    }

    @Override //function update พลังโจมตีของแหวน
    public void upState() { //update damage ของแหวน (พลังโจมตีของผู้เล่นเพิ่มขึ้น)
        damage = d*2;
    }

    //function ส่งค่าพลังโจมตีของแหวน
    public double getDamageRing() {
        upState();
        return damage;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public String getName() {
        return name;
    }
}