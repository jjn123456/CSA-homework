import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Callable;

interface Heroattack{
    public int physicalatc(Monster m);
    public int skillatc(Monster m);
    public int finalbigatc(Monster m);
}
interface Monsterattack{
    public int physicalatc(Hero h);
}
class Person{
    public String name;
    public int hp;
}

class Hero extends Person implements Heroattack{
    private int attack;    //攻击力
    private int defense;   //防御力

    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }


    @Override
    public int physicalatc(Monster m) {
        System.out.println(this.name+"对"+m.name+"进行拳头攻击造成了"+this.attack+"点伤害!");
        int mhp1 = m.hp - this.attack;
        return mhp1;
    }

    @Override
    public int skillatc(Monster m) {
        System.out.println(this.name+"对"+m.name+"使用胸肌夹击造成了"+(this.attack*2)+"点伤害!");
        int mhp2 = m.hp - attack*2;
        return mhp2;
    }

    @Override
    public int finalbigatc(Monster m) {
        int mhp3 = m.hp - attack;
        return mhp3;
    }
}

class Monster extends Person implements Monsterattack{
    private int attack;                              //攻击力
    public Monster(String name,int hp,int attack){   //构造方法
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }
    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public int physicalatc(Hero h) {
        System.out.println(this.name+"对"+h.name+"使用跳跳攻击造成了"+(this.attack-h.getDefense())+"点伤害!");
        int mhp1 = h.hp - this.attack+h.getDefense();
        return mhp1;
    }
}

public class Dome1 {
    public static int count = 1;                             //记录回合数
    public static int Truthdeth = 0;                         //记录怪物真实阵亡数，这样避免采用arraylist.remove
    public static void Create(Person p) {                    //No.1人物创建
        Scanner input = new Scanner(System.in);
        Hero player1 = (Hero) p;
        System.out.println("请输入请输入玩家的基本信息.");
        System.out.println("姓名:(50个字符以内)");
        player1.name = input.nextLine();
        System.out.println("生命值:(100-999)");
        player1.hp = input.nextInt();
        System.out.println("初始攻击力:(1-666)");
        player1.setAttack(input.nextInt());
        System.out.println("初始防御力:(1-25)");
        player1.setDefense(input.nextInt());
        //打印玩家1的各个属性
        System.out.println("玩家的姓名:" + player1.name + "\n生命值:  " + player1.hp + "\n初始攻击力:" +
                player1.getAttack() + "\n初始防御力:" + player1.getDefense());
    }

    public static Monster CreatMonster(String name1,int hp1,int attack1) {
        Monster s0 = new Monster(name1, hp1, attack1);
        Random rand = new Random();
        int c1 = rand.nextInt(9);     //调节初始属性的随机值
        if (c1 % 2 == 1) {                         //c1是基数的话对应的初始值就 +
            s0.hp = s0.hp + c1 * 10;
            s0.setAttack(s0.getAttack() + c1);
        }
        if (c1 % 2 == 0) {                    //c1是偶数的话对应的初始值就 -
            s0.hp = s0.hp - c1 * 5;
            s0.setAttack(s0.getAttack() + c1);
        }
        return s0;
    }

    public static void main(String[] args) {
        ArrayList<Monster> monsterlist = new ArrayList<>();
        ArrayList<Monster> monsterlist2 = new ArrayList<>();
        Hero player1 = new Hero();
        Create(player1);                                        //调用函数创建人物
        System.out.println("----------***********---------");
        System.out.println("下面开始初始化怪物");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入怪物的名字:(50个字符以内)");
        String name9 = input.nextLine();
        System.out.println("请输入怪物生命值:(150-200)");
        int hp1 = input.nextInt();
        System.out.println("请输入怪物初始攻击力:");
        int attack1 = input.nextInt();
        if(attack1 <= player1.getDefense()){
            System.out.println("他们对你那么温柔为什么要跟他们开战？");
            System.exit(1);
        }
        for (int i=0;i<3;i++){
            String name1 = name9+(i+1);
            Monster M1 = CreatMonster(name1,hp1,attack1);
            monsterlist.add(M1);
        }
        for (int i=0;i<3;i++){
            System.out.println("小怪兽:"+monsterlist.get(i).name+"\t生命值:"+
                    monsterlist.get(i).hp + "\t攻击力"+monsterlist.get(i).getAttack());
        }
        System.out.println("----------***开始战斗***---------");
        System.out.println("-------------------------------");
        Heroattack p = player1;
        while ((monsterlist.size()>0)||(player1.hp<=0)){
            System.out.println("\n----------第"+count+"回合---------");
            System.out.println("轮到"+player1.name+"采取行动");
            System.out.println("1.普通攻击");
            System.out.println("2.*技能*");
            System.out.println("3.终极大招");                            //大招范围伤害
            System.out.println("你选择的攻击方式为(输入1或2或3):");
            int atcfangsi = input.nextInt();
            int j;
            int pmubiao=1;
            if(atcfangsi==1||atcfangsi==2) {
                input.nextLine();                                     //读走回车换行符
                System.out.print("请复制你攻击的目标的名字:");
                String pchoose = input.nextLine();
                for (j=0;j<monsterlist.size();j++){
                    if(monsterlist.get(j).name.equals(pchoose)){
                       pmubiao = j+1;
                       break;
                    }
                }
                if(j==monsterlist.size()){
                    System.out.println("输入的名字有误,(胆小鬼)游戏结束!");
                    System.exit(1);
                }
                if(atcfangsi==1){                                                  //普通攻击
                    monsterlist.get(pmubiao-1).hp = p.physicalatc(monsterlist.get(pmubiao-1));
                    if(monsterlist.get(pmubiao-1).hp<=0){
                        System.out.println(monsterlist.get(pmubiao-1).name+"阵亡!");
                        monsterlist.remove(monsterlist.get(pmubiao-1));            //移除一个就这样写
                        //Truthdeth++;
                    }
                    for (int i=0;i<monsterlist.size();i++){                        //打印剩下所有的怪物部分属性
                        if(monsterlist.get(i).hp>0)
                            System.out.println("怪兽:"+monsterlist.get(i).name+"\t生命值:"+
                                    monsterlist.get(i).hp);
                    }
                }
                if(atcfangsi==2){                                                //二技能是单体高伤害
                    monsterlist.get(pmubiao-1).hp = p.skillatc(monsterlist.get(pmubiao-1));
                    if(monsterlist.get(pmubiao-1).hp<=0){
                        System.out.println(monsterlist.get(pmubiao-1).name+"阵亡!");
                        monsterlist.remove(monsterlist.get(pmubiao-1));            //移除一个就这样写
                        //Truthdeth++;
                    }
                    for (int i=0;i<monsterlist.size();i++){                        //打印剩下所有的怪物部分属性
                        if(monsterlist.get(i).hp>0)
                            System.out.println("怪兽:"+monsterlist.get(i).name+"\t生命值:"+
                                    monsterlist.get(i).hp);
                    }
                }
            }
            if(atcfangsi==3){                                                      //大招是范围伤害
                System.out.println(player1.name+"使用AK-47一顿猛扫对每个敌人造成了"+player1.getAttack()+"点伤害!");
                for (int i=0;i<monsterlist.size();i++){
                    monsterlist.get(i).hp = p.finalbigatc(monsterlist.get(i));
                }
                for (int i=0;i<monsterlist.size();i++){
                    if(monsterlist.get(i).hp<=0) {
                        System.out.println(monsterlist.get(i).name + "阵亡!");
                        monsterlist2.add(monsterlist.get(i));                  //有多个阵亡的,就重新移入另一个集合
                    }
                }
                monsterlist.removeAll(monsterlist2);                           //一起再删除
                for (int i=0;i<monsterlist.size();i++) {                        //打印剩下所有的怪物部分属性
                    System.out.println("怪兽:" + monsterlist.get(i).name + "\t生命值:" + monsterlist.get(i).hp);
                }
            }
            if(0==monsterlist.size()){
                System.out.println("恭喜你获得游戏胜利!\nHappy ending!");
                System.exit(0);
            }
            System.out.println("轮到"+name9+"行动.");
            for (int i=0;i<monsterlist.size();i++) {
                if (monsterlist.get(i).hp > 0) {
                    Monsterattack m = monsterlist.get(i);
                    player1.hp = m.physicalatc(player1);
                }
            }
            //打印玩家的剩余生命值
            System.out.println(player1.name + "的剩余生命值为:  " + player1.hp);
            if(player1.hp<=0){
                System.out.println(name9+"获胜!\n感谢你的游玩!");
            }
            count++;
        }
        return;
    }
}
