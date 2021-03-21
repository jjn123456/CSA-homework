import java.lang.reflect.*;

public class reflectext {
    public static  <T> void leizhuanStringshuxing(T t) throws IllegalAccessException, InstantiationException {
        Class clazz = t.getClass();                  //一个类只有一个类的加载器
        T obj = (T) clazz.newInstance();
        Field[] publicfs = clazz.getFields();
        Field[] privatefs = clazz.getDeclaredFields();
        System.out.println("{");
        if (publicfs.length > 0) {                 //里面有公有属性
            for (Field pubfld : publicfs) {
                String name = pubfld.getName();
                String pubo = String.valueOf(pubfld.get(obj));  //这种方式可以打印null，直接toString的话若字符串没有初始化会报错
                System.out.println(name + ": " + pubo);
            }
        } else {
            System.out.println(clazz.getName() + "类没有公有属性~");
        }
        if (privatefs.length > 0) {               //里面有私有有属性
            for (Field prifld : privatefs) {
                String name = prifld.getName();
                prifld.setAccessible(true);
                String prio = String.valueOf(prifld.get(obj));
                System.out.println(name + ": " + prio);
            }
        } else {
            System.out.println(clazz.getName() + "类没有私有属性~");
        }
        System.out.println("}");
    }
    public static <T> void leizhuanStringshuxing(T[] ts) throws IllegalAccessException, InstantiationException {
        Class clazz = ts[0].getClass();                  //一个类只有一个类的加载器
        T obj = (T) clazz.newInstance();
        Field[] publicfs = clazz.getFields();
        Field[] privatefs = clazz.getDeclaredFields();
        for (int y = 0; y < ts.length; y++) {
            System.out.println("{*");
            if (publicfs.length > 0) {                 //里面有公有属性
                for (Field pubfld : publicfs) {
                    String name = pubfld.getName();
                    String pubo = String.valueOf(pubfld.get(obj));  //这种方式可以打印null，直接toString的话若字符串没有初始化会报错
                    System.out.println(name + ": " + pubo);
                }
            } else {
                System.out.println(clazz.getName() + "类没有公有属性~");
            }
            if (privatefs.length > 0) {               //里面有私有有属性
                for (Field prifld : privatefs) {
                    String name = prifld.getName();
                    prifld.setAccessible(true);
                    String prio = String.valueOf(prifld.get(obj));
                    System.out.println(name + ": " + prio);
                }
            } else {
                System.out.println(clazz.getName() + "类没有私有属性~");
            }
            System.out.println("*}");
        }
    }
    public static  <T> void leizhuanStringgouzao(T t) throws IllegalAccessException, InstantiationException{
        Class cls = t.getClass();
        Constructor[] cons = cls.getConstructors();
        for (int i=0;i< cons.length;i++){
            Constructor con = cons[i];                                  //取出第i个构造方法
            System.out.print(Modifier.toString(con.getModifiers()));  //
            System.out.print(" "+con.getName()+"( ");                    ////打印该构造方法的名字
            Class[] printcanshu = con.getParameterTypes();
            for (int j=0;j< printcanshu.length;j++){
                System.out.print(printcanshu[j].getName()+" ");
            }
            System.out.println(")");
        }
    }
    public static  <T> void leizhuanStringfangfa(T t) throws IllegalAccessException, InstantiationException{
        Class cls2 = t.getClass();
        Method[] methods1 = cls2.getMethods();
        Method[] methods2 = cls2.getDeclaredMethods();
        for (int i=0;i< methods1.length;i++)
        {
            Class fanhuizhi = methods1[i].getReturnType();          //方法的返回值
            Class canshu[] = methods1[i].getParameterTypes();       //方法的全部参数
            int xx = methods1[i].getModifiers();
            System.out.print(Modifier.toString(xx)+" "+fanhuizhi.getName()+" "+methods1[i].getName()+"(");
            //下面罗列全部的形参类型
            for (int x=0;x< canshu.length;x++){
                System.out.print(canshu[x].getName());
                if(x<canshu.length-1)
                    System.out.print(",");
            }
            System.out.println(")");
        }
        for (int i=0;i< methods2.length;i++){
            Class fanhuizhi2 = methods2[i].getReturnType();
            Class canshu2[] = methods2[i].getParameterTypes();
            int xxx = methods2[i].getModifiers();
            System.out.print(Modifier.toString(xxx)+" "+fanhuizhi2.getName()+" "+methods2[i].getName()+"(");
            for (int x = 0;x< canshu2.length;x++){
                System.out.print(canshu2[x].getName());
                if (x< canshu2.length-1)
                    System.out.print(",");
            }
                System.out.print(")\n");
        }
        System.out.println(methods2.length);
        System.out.println(methods1.length);
    }



    public static void main(String[] args) throws Exception {
        Person[] pes =  new Person[3];
            pes[0] = new Person();
        leizhuanStringshuxing(pes);     //传递的是一个数组
        leizhuanStringshuxing(new Hero());
        leizhuanStringfangfa(new Hero());  //得到对象的方法
        leizhuanStringgouzao(new Hero());  //得到对象的构造
    }
}
