package Homework;

import java.util.ArrayList;

public class get_Num{
    int N;
    int i;
    ArrayList<Integer> arr;
    public get_Num(int n, int i,ArrayList<Integer> a){
        this.N = n;
        this.i = i;
        this.arr = a;
    }
    public void change_array(){
        if(this.N % this.i == 0){
            arr.add(i);
            arr.add(N/i);
            System.out.println("将("+ i +","+N/i+")添加进入了数组");
        }
    }
}
