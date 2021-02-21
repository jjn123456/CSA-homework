package Testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//我这里第一种方法采用
public class mylowLevel {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一开始的集合中有几个数:");
        int n = input.nextInt();
        int i,j;
        for(i=0;i<n;i++){
            System.out.print("第"+(i+1)+"个数:");
            array.add(input.nextInt());
        }
        System.out.println("该集合是："+array);
        Collections.sort(array);
        System.out.println("排序后的结果：");
        System.out.println(array);
        System.out.println("又想添加几个数: ");
        int m = input.nextInt();
        for(j=m;j<n+m;j++){
            array.add(j,input.nextInt());
        }
        System.out.println("最后排序后的结果：");
        Collections.sort(array);
        System.out.println(array);
    }
}