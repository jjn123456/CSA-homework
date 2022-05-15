package Homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class TestThread{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int p = (int)Math.sqrt(n);
        Main m[] = new Main[100];
        Thread t[] = new Thread[100];//创建线程数组
        ArrayList<Integer> array = new ArrayList<Integer>();//共享缓冲区
        array.add(1);
        for (int i=2,j=0;i<=p;i++,j++) {
            get_Num g = new get_Num(n, i, array);
            m[j] = new Main(g);
            t[j] = new Thread(m[j]);
            t[j].start();
        }
        int Flag = 1;
        do {
            Flag = 1;
            for(int z=0; z<=p-2; z++){
                if(t[z].isAlive()){
                    Flag = 0;
                    break;
                }
            }
        }while (Flag==0);
        System.out.println("--全部线程都执行结束--");
        HashSet<Integer> set = new HashSet<>();
        for (int i:array) {
            set.add(i);
        }
        Integer[] ans = set.toArray(new Integer[set.size()]);
        System.out.println("最后的结果数组为:");
        int temp = 0;
        for (int num:ans) {
            temp += num;
            System.out.print(num+" ");
        }
        if (temp==n){
            System.out.println("\n输入的"+n+"是完数。");
        }else{
            System.out.println("\n输入的"+n+"不是完数。");
        }
    }
}
