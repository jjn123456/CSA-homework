package Homework;

import java.util.ArrayList;

public class Main implements Runnable{
    get_Num g1;
    public Main(get_Num getnum1){
        this.g1 = getnum1;
    }
    @Override
    public void run() {
        try{
            System.out.println((g1.i - 2)+"号线程已经启动");
            System.out.println((g1.i - 2)+"号线程 试图占有 共享缓冲区");
            synchronized (g1.arr) {
                System.out.println((g1.i - 2)+"号线程 成功占有 共享缓冲区");
                g1.change_array();
                System.out.println((g1.i - 2)+"号线程 释放 共享缓冲区");
            }
            Thread.sleep(100);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
