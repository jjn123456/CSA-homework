import java.lang.reflect.Field;

public class Person {
    public String name="test";
    public boolean gender=false;

    private int age=Integer.MAX_VALUE;
    private double score=Double.MIN_VALUE;


    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
}