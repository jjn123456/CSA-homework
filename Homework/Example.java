package Homework;
import java.util.Scanner;


class Retangle{
    double x = 120;
    double y = 20;
    Retangle(double a,double b){
        this.x = a;
        this.y = b;
    }

    public void myString() {
        System.out.println("The lengh is:"+this.x);
        System.out.println("The width is:"+this.y);
        System.out.println("The area is:"+this.x*this.y);
    }
}


public class Example {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input length: ");
        double length = in.nextDouble();
        System.out.println("Please input width: ");
        double width = in.nextDouble();
        Retangle r = new Retangle(length, width);
        r.myString();
    }
}
