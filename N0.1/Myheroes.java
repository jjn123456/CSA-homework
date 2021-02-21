package Testing;


import java.util.Scanner;
import java.util.Arrays;
class Myheroes{
    //排序的函数
    public static void paixu(int[] a){
        for(int i=0;i<a.length-1;i++){
            int k = i;
            for(int j=i+1;j<a.length;j++){
                if(a[k]>a[j]){
                    k=j;
                }
            }
            if(k!=i){
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] num = new int[100];
        for(int i=0;i< num.length;i++) {num[i]=-1001;}

        System.out.println("你想输入几个数字?");
        int n = input.nextInt();
        for(int i=0;i<n;i++){
            num[i] = input.nextInt();
        }
        paixu(num);
        for(int i=0;i< num.length;i++){
            if(num[i]>-1001){
                System.out.print(num[i]+" ");
            }
        }
        System.out.println("\n你再输入几个数字?");
        int m = input.nextInt();
        for(int i=0;i<m;i++){
            num[i] = input.nextInt();
        }
        paixu(num);
        System.out.println("合并后的结果：");
        for(int i=0;i< num.length;i++){
            if(num[i]>-1001){
                System.out.print(num[i]+" ");
            }
        }
    }
}