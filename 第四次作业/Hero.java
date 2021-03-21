import MyDungeon.Monster;

public class Hero {
    private String name ;
    private int Hp = 100;
    private Person p = new Person();
    public Hero(){}
    public Hero(String name){
        this.name = name;
    }
    public Hero(String name,int hp){
        this.Hp = hp;
        this.name = name;
    }

    public int getHp() {
        return Hp;
    }
    public void setHp(int hp) {
        Hp = hp;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private void Attack(Object obj){
        System.out.println(this.name+"对敌人发起了攻击。");
    }
    private void relax(String name){
        System.out.println(this.name+"在"+name+"处休息回复50点生命值");
    }
}
